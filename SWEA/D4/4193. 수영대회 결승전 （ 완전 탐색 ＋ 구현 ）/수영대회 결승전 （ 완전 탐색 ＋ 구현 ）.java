import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution
{
	static int N, sx, sy, ex, ey, arr[][];
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            st = new StringTokenizer(br.readLine());

            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());

            Queue<Node> q = new ArrayDeque<>();
            boolean[][][] visit = new boolean[3][N][N];

            q.offer(new Node(sx, sy, 1));
            visit[0][sx][sy] = true;

            int result = -1;

            while (!q.isEmpty()) {
                Node now = q.poll();

                if (now.x == ex && now.y == ey) {
                    result = now.cnt - 1;
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                        continue;

                    if (arr[nx][ny] == 1 || visit[0][nx][ny])
                        continue;

                    if (arr[nx][ny] == 2) {
                        if (now.cnt % 3 != 0) {
                            if (!visit[now.cnt % 3][now.x][now.y]) {
                                q.offer(new Node(now.x, now.y, now.cnt + 1));
                                visit[now.cnt % 3][now.x][now.y] = true;
                            }
                        } else {
                            q.offer(new Node(nx, ny, now.cnt + 1));
                            visit[0][nx][ny] = true;
                        }
                    }

                    if (arr[nx][ny] == 0) {
                        q.offer(new Node(nx, ny, now.cnt + 1));
                        visit[0][nx][ny] = true;
                    }
                }
            }

            sb.append("#").append(test).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}

class Node {
    int x, y, cnt;

    public Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}