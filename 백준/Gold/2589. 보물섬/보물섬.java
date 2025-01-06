import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static char[][] arr;
    static List<int[] > list;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        input();

        int max = 0;

        for(int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);
            
            max = Math.max(max, bfs(now[0], now[1]));
        }

        System.out.println(max);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);

                if(arr[i][j] == 'L') {
                    list.add(new int[]{i, j});
                }
            }
        }
    }

    static int bfs(int sx, int sy) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];
        q.add(new Node(sx, sy, 0));
        visit[sx][sy] = true;

        int len = 0;
        while(!q.isEmpty()) {
            Node now = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(arr[nx][ny] == 'W' || visit[nx][ny]) continue;

                visit[nx][ny] = true;
                q.add(new Node(nx, ny, now.cnt + 1));
                len = Math.max(len, now.cnt + 1);
            }
        }

        return len;
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