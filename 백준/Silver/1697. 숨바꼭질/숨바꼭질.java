import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈
        int K = Integer.parseInt(st.nextToken()); // 동생

        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visit = new boolean[100_001];

        q.add(new int[]{N, 0});
        visit[N] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == K) {
                System.out.println(now[1]);
                break;
            }

            if (now[0] * 2 <= 100_000 && !visit[now[0] * 2]) {
                visit[now[0] * 2] = true;
                q.offer(new int[] { now[0] * 2, now[1] + 1 });
            }

            if (now[0] + 1 <= 100_000 && !visit[now[0] + 1]) {
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