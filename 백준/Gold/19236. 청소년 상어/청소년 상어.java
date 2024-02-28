import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
    static int max = 0;
    static List<shark> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][][] arr = new int[4][4][2]; // 0: 번호, 1: 방향
        boolean[] visit = new boolean[17];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j][0] = Integer.parseInt(st.nextToken());
                arr[i][j][1] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        shark_move(arr, visit, 0, 0, 0);

        System.out.println(max);
    }

    // 2. 물고기 이동
    static void fish_move(int[][][] arr, boolean[] visit, int shark_x, int shark_y) {
        int idx = 1;

        while (idx != 17) {
            if (visit[idx]) {
                idx++;
            }

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (arr[i][j][0] == idx) {

                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[(arr[i][j][1] + k) % 8];
                            int ny = j + dy[(arr[i][j][1] + k) % 8];

                            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4 || (nx == shark_x && ny == shark_y))
                                continue;

                            int tmp_idx = idx;
                            int tmp_d = (arr[i][j][1] + k) % 8;

                            arr[i][j][0] = arr[nx][ny][0];
                            arr[i][j][1] = arr[nx][ny][1];

                            arr[nx][ny][0] = tmp_idx;
                            arr[nx][ny][1] = tmp_d;

                            break;
                        }
                        idx++;
                        break;
                    }
                }
            }
        }
    }

    // 3. 상어 이동
    static void shark_move(int[][][] arr, boolean[] visit, int x, int y, int cnt) { // x좌표, y좌표, 방향, 물고기잡은번호합
        int[][][] tmp = new int[4][4][2]; // 기존 배열 저장
        boolean[] copy_visit = new boolean[17];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 2; k++) {
                    tmp[i][j][0] = arr[i][j][0];
                    tmp[i][j][1] = arr[i][j][1];
                }
            }
        }

        for (int i = 0; i < 17; i++) {
            copy_visit[i] = visit[i];
        }

        // 물고기 먹음
        int fish_idx = tmp[x][y][0];
        int dir = tmp[x][y][1];
        copy_visit[fish_idx] = true;
        tmp[x][y][0] = -1;

        cnt += fish_idx;
        max = Math.max(max, cnt);

        // 물고기 이동
        fish_move(tmp, copy_visit, x, y);

        // 상어 이동
        for (int i = 1; i <= 3; i++) {
            int nx = x + dx[dir] * i;
            int ny = y + dy[dir] * i;

            if (nx < 0 || ny < 0 || nx >= 4 || ny >= 4) {
                continue;
            }

            if (tmp[nx][ny][0] != -1)
                shark_move(tmp, copy_visit, nx, ny, cnt);
        }
    }
}

class shark {
    int x, y, d, cnt;

    shark(int x, int y, int d, int cnt) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.cnt = cnt;
    }
}