import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H, map[][];
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[] kx = {2,2,-2,-2,1,-1,1,-1};
    static int[] ky = {-1,1,-1,1,2,2,-2,-2};
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken()); // 가로
        H = Integer.parseInt(st.nextToken()); // 세로

        map = new int[H][W];
        visit = new boolean[H][W][K+1];

        for(int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }
    
    public static int bfs() {
        Queue<M> q = new ArrayDeque<>();
        q.offer(new M(0, 0, 0, K)); 
        visit[0][0][K] = true;
        
        while(!q.isEmpty()) {
            M current = q.poll();
            if(current.x == H - 1 && current.y == W - 1) return current.cnt; 
            
            for(int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < H && ny < W && !visit[nx][ny][current.K] && map[nx][ny] == 0) {
                    visit[nx][ny][current.K] = true;
                    q.offer(new M(nx, ny, current.cnt + 1, current.K));
                }
            }
            
            if(current.K > 0) {
                for(int i = 0; i < 8; i++) {
                    int nx = current.x + kx[i];
                    int ny = current.y + ky[i];
                    if(nx >= 0 && ny >= 0 && nx < H && ny < W && !visit[nx][ny][current.K - 1] && map[nx][ny] == 0) {
                        visit[nx][ny][current.K - 1] = true;
                        q.offer(new M(nx, ny, current.cnt + 1, current.K - 1));
                    }
                }
            }
        }
        return -1;
    }
}

class M{
    int x, y, cnt, K;
    
    M(int x, int y, int cnt, int K) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.K = K;
    }
}