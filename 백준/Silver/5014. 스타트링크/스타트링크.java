import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F, S, G, U, D;
    static boolean[] visit;
    static Queue<P> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visit = new boolean[F + 1];

        q.offer(new P(S, 0));
        visit[S] = true;

        while (!q.isEmpty()) {
            P now = q.poll();
            int up = now.s + U;
            int down = now.s - D;

            if (now.s == G) {
                System.out.println(now.cnt);
                System.exit(0);
            }

            if (up <= F && !visit[up]) {
                visit[up] = true;
                q.offer(new P(up, now.cnt + 1));
            }

            if (down > 0 && !visit[down]) {
                visit[down] = true;
                q.offer(new P(down, now.cnt + 1));
            }
        }

        System.out.println("use the stairs");
    }
}

class P {
    int s;
    int cnt;

    public P(int s, int cnt) {
        this.s = s;
        this.cnt = cnt;
    }
}