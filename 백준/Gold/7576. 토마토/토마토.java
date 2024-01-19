import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int result = -1;
    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        boolean[][] check = new boolean[N][M];
        Queue<Tomato> q = new LinkedList<>();

        int zero = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.offer(new Tomato(i, j, 0));
                    check[i][j] = true;
                }
                if (arr[i][j] == 0) {
                    zero++;
                }
            }
        }

        int[] x = { -1, 1, 0, 0 };
        int[] y = { 0, 0, -1, 1 };

        if (zero == 0) {
            result = 0;
        } else {
            while (!q.isEmpty()) {
                Tomato t = q.poll();

                if (arr[t.x][t.y] == 0) {
                    arr[t.x][t.y] = 1;
                    zero--;
                }

                if (zero == 0) {
                    result = t.r;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = t.x + x[i];
                    int nextY = t.y + y[i];

                    if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M &&
                            !check[nextX][nextY]
                            && arr[nextX][nextY] != -1) {
                        check[nextX][nextY] = true;
                        q.offer(new Tomato(nextX, nextY, t.r + 1));
                    }
                }
            }
        }

        System.out.println(result);
    }
}

class Tomato {
    int x;
    int y;
    int r;

    public Tomato(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}