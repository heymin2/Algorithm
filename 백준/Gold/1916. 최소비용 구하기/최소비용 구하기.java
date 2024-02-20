import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수

        int[][] arr = new int[N][N];
        int[] visit = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = -1;
            }
            visit[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int pay = Integer.parseInt(st.nextToken());

            if (arr[s][e] == -1 || arr[s][e] > pay) {
                arr[s][e] = pay;
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        PriorityQueue<bus> pq = new PriorityQueue<>();
        visit[start] = 0;
        pq.offer(new bus(start, 0));

        while (!pq.isEmpty()) {
            bus now = pq.poll();

            if (now.x == end) {
                System.out.println(now.pay);
                break;
            }

            for (int i = 0; i < N; i++) {
                if (arr[now.x][i] != -1 && visit[i] > now.pay) {
                    visit[i] = now.pay + arr[now.x][i];
                    pq.offer(new bus(i, now.pay + arr[now.x][i]));
                }
            }
        }
    }
}

class bus implements Comparable<bus> {
    int x;
    int pay;

    bus(int x, int pay) {
        this.x = x;
        this.pay = pay;
    }

    @Override
    public int compareTo(bus o) {
        return this.pay - o.pay;
    }
}