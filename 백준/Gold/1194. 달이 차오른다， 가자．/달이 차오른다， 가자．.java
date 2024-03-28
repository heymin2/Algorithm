import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][] visit;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new boolean[64][N][M]; // 열쇠 몇개 들고있는지 표시

        Queue<Minsik> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == '0') {
                    q.offer(new Minsik(i, j, 0, 0));
                    visit[0][i][j] = true;
                }
            }
        }

        int result = -1;

        while (!q.isEmpty()) {
            Minsik now = q.poll();

            if (map[now.x][now.y] == '1') {
                result = now.time;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '#')
                    continue;

                if (visit[now.key][nx][ny]) {
                    continue;
                }

                if ('a' <= map[nx][ny] && map[nx][ny] <= 'f') {
                    int key = now.key | 1 << (map[nx][ny] - 'a');
                    visit[key][nx][ny] = true;
                    q.offer(new Minsik(nx, ny, now.time + 1, key));
                }

                if ('A' <= map[nx][ny] && map[nx][ny] <= 'F') {
                    if ((now.key & 1 << (map[nx][ny] - 'A')) > 0) {
                        visit[now.key][nx][ny] = true;
                        q.offer(new Minsik(nx, ny, now.time + 1, now.key));
                    }
                }

                if (map[nx][ny] == '0' || map[nx][ny] == '.' || map[nx][ny] == '1') {
                    visit[now.key][nx][ny] = true;
                    q.offer(new Minsik(nx, ny, now.time + 1, now.key));
                }
            }
        }

        System.out.println(result);
    }
}

class Minsik {
    int x, y, time, key;

    Minsik(int x, int y, int time, int key) {
        this.x = x;
        this.y = y;
        this.time = time;
        this.key = key;
    }
}