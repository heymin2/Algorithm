import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int[] x = { 1, 1, -1, -1, 2, 2, -2, -2 };
    static int[] y = { 2, -2, 2, -2, 1, -1, 1, -1 };

    static int I, startX, startY, endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            I = Integer.parseInt(br.readLine());
            arr = new int[I][I];
            visit = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());

            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            System.out.println(bfs());
        }
    }

    static int bfs() {
        Queue<Chess> q = new LinkedList<>();

        q.offer(new Chess(startX, startY, 0));

        while (!q.isEmpty()) {
            Chess c = q.poll();

            if (c.x == endX && c.y == endY) {
                return c.cnt;
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    int nextX = c.x + x[i];
                    int nextY = c.y + y[i];
                    if (nextX >= 0 && nextY >= 0 && nextX < I && nextY < I && !visit[nextX][nextY]) {
                        visit[nextX][nextY] = true;
                        q.offer(new Chess(nextX, nextY, c.cnt + 1));
                    }
                }
            }
        }
        return 0;
    }
}

class Chess {
    int x;
    int y;
    int cnt;

    public Chess(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}