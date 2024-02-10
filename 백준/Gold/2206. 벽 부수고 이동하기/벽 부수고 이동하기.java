import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        boolean[][][] visit = new boolean[2][N][M];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }   
        }

        Queue<Wall> q = new ArrayDeque<>();

        q.add(new Wall(0, 0, 1));
        visit[0][0][0] = true;

        while (!q.isEmpty()) {
            Wall now = q.poll();

            if(now.x == N-1 && now.y == M-1){
                System.out.println(now.cnt);
                System.exit(0);
            }

            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(arr[nx][ny] == 0){ // 벽이 아닐 때
                    if(!visit[now.p][nx][ny]){
                        visit[now.p][nx][ny] = true;
                        q.offer(new Wall(nx, ny, now.cnt+1, now.p));
                    }
                }
                else{ // 벽일 때
                    if(now.p == 1 && !visit[1][nx][ny]){  // 벽 부순 적 없음
                        q.offer(new Wall(nx, ny, now.cnt+1, 0)); // 벽 부수기
                        visit[1][nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}

class Wall{
    int x, y, cnt, p = 1;

    Wall(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    Wall(int x, int y, int cnt, int p){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.p = p;
    }
}