import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { -1, 0, 1, 0 }; // 시계방향(북,동,남,서);
    static int[] dy = { 0, 1, 0, -1 };
    static int N, M, r, c, d;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            if (map[r][c] == 0) { // 현재 칸 청소
                cnt++;
                map[r][c] = cnt + 1;
            }

            boolean flag = true;

            for (int i = 0; i < 4; i++) {
                d -= 1;
                if (d == -1) {
                    d = 3;
                }

                int nx = r + dx[d];
                int ny = c + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;

                if (map[nx][ny] == 0) {
                    r = nx;
                    c = ny;
                    flag = false;
                    break;
                }
            }

            if (flag) {
                int nx = r + dx[d] * -1;
                int ny = c + dy[d] * -1;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 1)
                    break;
                else {
                    r = nx;
                    c = ny;
                }
            }
        }

        System.out.println(cnt);
    }
}