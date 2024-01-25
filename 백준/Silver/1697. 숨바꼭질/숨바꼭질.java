import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            Queue<int[]> q = new LinkedList<>();
            boolean[] visit = new boolean[100001];

            q.offer(new int[] { N, 0 });
            visit[N] = true;

            while (!q.isEmpty()) {
                int[] now = q.poll();

                if (now[0] == K) {
                    System.out.println(now[1]);
                    break;
                }

                if (now[0] * 2 <= 100000 && !visit[now[0] * 2]) {
                    visit[now[0] * 2] = true;
                    q.offer(new int[] { now[0] * 2, now[1] + 1 });
                }

                if (now[0] + 1 <= 100000 && !visit[now[0] + 1]) {
                    visit[now[0] + 1] = true;
                    q.offer(new int[] { now[0] + 1, now[1] + 1 });
                }

                if (now[0] - 1 >= 0 && !visit[now[0] - 1]) {
                    visit[now[0] - 1] = true;
                    q.offer(new int[] { now[0] - 1, now[1] + 1 });
                }
            }
        }
    }
}