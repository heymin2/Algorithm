import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][];
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int test = 1;

        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(test).append(": ").append(re()).append("\n");
            test++;
        }

        System.out.println(sb);
    }

    static int re() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, arr[0][0]));
        boolean[][] visit = new boolean[N][N];
        visit[0][0] = true;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.x == N - 1 && now.y == N - 1) {
                return now.sum;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                    continue;

                if (visit[nx][ny])
                    continue;

                visit[nx][ny] = true;
                pq.offer(new Node(nx, ny, now.sum + arr[nx][ny]));
            }
        }

        return 0;
    }
}

class Node implements Comparable<Node> {
    int x, y, sum;

    Node(int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }

    @Override
    public int compareTo(Node o) {
        return sum - o.sum;
    }
}