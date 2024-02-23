import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[][], hour = 0, c = 0;
    static boolean[][] visit;
    static Queue<Search> q;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q = new ArrayDeque<>();

        while (true) {
            visit = new boolean[N][M];
            if (!bfs()) {
                break;
            }
        }

        System.out.println(c - 1);
        System.out.println(hour);
    }

    static boolean bfs() {
        c++;

        q.offer(new Search(0, 0));
        visit[0][0] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            Search now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny])
                    continue;

                if (arr[nx][ny] == 0) {
                    q.offer(new Search(nx, ny));
                } else {
                    arr[nx][ny] = 0;
                    cnt++;
                }
                visit[nx][ny] = true;
            }
        }

        if (cnt == 0) {
            return false;
        } else {
            hour = cnt;
            return true;
        }
    }
}

class Search {
    int x, y;

    Search(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}