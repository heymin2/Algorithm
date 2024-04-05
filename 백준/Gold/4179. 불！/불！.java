import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c, sx, sy;
    static char map[][];
    static boolean[][] visit;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visit = new boolean[r][c];
        Queue<int[]> list = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'J') {
                    sx = i;
                    sy = j;
                    map[i][j] = '.';
                }

                if (map[i][j] == 'F') {
                    list.add(new int[] { i, j });
                }
            }
        }

        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(sx, sy, 1));
        visit[sx][sy] = true;
        int result = -1;

        outerLoop: while (!q.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int[] fire = list.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = fire[0] + dx[j];
                    int ny = fire[1] + dy[j];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c)
                        continue;

                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'F';
                        list.offer(new int[] { nx, ny });
                    }
                }
            }

            size = q.size();

            for (int i = 0; i < size; i++) {
                Node now = q.poll();

                if (now.x == 0 || now.y == 0 || now.x == r - 1 || now.y == c - 1) {
                    result = now.cnt;
                    break outerLoop;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= r || ny >= c)
                        continue;

                    if (visit[nx][ny] || map[nx][ny] == 'F' || map[nx][ny] == '#')
                        continue;

                    visit[nx][ny] = true;
                    q.offer(new Node(nx, ny, now.cnt + 1));
                }
            }
        }

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }
}

class Node {
    int x, y, cnt;

    Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}