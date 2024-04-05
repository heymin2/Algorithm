import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h, sx, sy, ex, ey;
    static char map[][];
    static boolean[][] visit;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new char[w][h];
        visit = new boolean[w][h];
        Queue<int[]> list = new ArrayDeque<>();

        for (int i = 0; i < w; i++) {
            String str = br.readLine();
            for (int j = 0; j < h; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'S') {
                    sx = i;
                    sy = j;
                    map[i][j] = '.';
                }

                if (map[i][j] == 'D') {
                    ex = i;
                    ey = j;
                }

                if (map[i][j] == '*') {
                    list.add(new int[] { i, j });
                }
            }
        }

        Queue<Node> q = new ArrayDeque<>();

        q.offer(new Node(sx, sy, 0));
        visit[sx][sy] = true;
        int result = -1;

        while (!q.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                int[] fire = list.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = fire[0] + dx[j];
                    int ny = fire[1] + dy[j];

                    if (nx < 0 || ny < 0 || nx >= w || ny >= h)
                        continue;

                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        list.offer(new int[] { nx, ny });
                    }
                }
            }

            size = q.size();

            for (int i = 0; i < size; i++) {
                Node now = q.poll();

                if (now.x == ex && now.y == ey) {
                    result = now.cnt;
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];

                    if (nx < 0 || ny < 0 || nx >= w || ny >= h)
                        continue;

                    if (visit[nx][ny] || map[nx][ny] == '*' || map[nx][ny] == 'X')
                        continue;

                    visit[nx][ny] = true;
                    q.offer(new Node(nx, ny, now.cnt + 1));
                }
            }
        }

        if (result == -1) {
            System.out.println("KAKTUS");
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