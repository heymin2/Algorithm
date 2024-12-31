import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        Queue<Node> q = new ArrayDeque<>();
        int[][] visit = new int[N][M];

        q.add(new Node(0, 0, 1));
        visit[0][0] = 1;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.x == N-1 && now.y == M-1) {
                System.out.println(now.cnt);
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int ncnt = now.cnt + 1;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(arr[nx][ny] == 0) continue;
                if(visit[nx][ny] != 0 && visit[nx][ny] <= ncnt) continue;

                q.add(new Node(nx, ny, ncnt));
                visit[nx][ny] = ncnt;
            }
        }
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