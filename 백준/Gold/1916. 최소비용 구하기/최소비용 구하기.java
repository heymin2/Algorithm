import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        int M = Integer.parseInt(br.readLine()); // 버스의 개수

        List<bus>[] graph = new ArrayList[N+1];
        int[] visit = new int[N+1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());

            graph[s].add(new bus(e, pay));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Arrays.fill(visit, Integer.MAX_VALUE);

        PriorityQueue<bus> pq = new PriorityQueue<>();
        visit[start] = 0;
        pq.offer(new bus(start, 0));

        while (!pq.isEmpty()) {
            bus now = pq.poll();

            if(now.x == end){
                System.out.println(now.pay);
                break;
            }

            for(bus next : graph[now.x]){
                if(visit[next.x] > now.pay + next.pay){
                    visit[next.x] = now.pay + next.pay;

                    pq.offer(new bus(next.x, visit[next.x]));
                }
            }
        }
    }
}

class bus implements Comparable<bus> {
    int x, pay;

    bus(int x, int pay) {
        this.x = x;
        this.pay = pay;
    }

    @Override
    public int compareTo(bus o) {
        return this.pay - o.pay;
    }
}