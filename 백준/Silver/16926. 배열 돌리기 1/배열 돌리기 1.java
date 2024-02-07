import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int S = Math.min(N, M) / 2;

        int[][] arr = new int[N][M];

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        // 반시계 순서: (0) ㅁ ← ㅁ (1) ㅁ ↑ ㅁ (2) ㅁ → ㅁ (3) ㅁ ↓ ㅁ

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int t = 0; t < R; t++) { // 회전수
            for (int i = 0; i < S; i++) { // 사각형 수
                int cnt = 0;
                int now = arr[i][i];
                int x = i, y = i;
                while (cnt != 4) {
                    int nextX = x + dx[cnt];
                    int nextY = y + dy[cnt];

                    if (nextX >= i && nextY >= i && nextX < N - i && nextY < M - i) {
                        arr[x][y] = arr[nextX][nextY];
                        x = nextX;
                        y = nextY;
                    } else {
                        cnt++;
                    }
                }
                arr[i + 1][i] = now;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}