import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution
{
	static int N, M, arr[][], max;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new int[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = 0;
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++){
                    bfs(i, j);
                }
            }

            sb.append("#").append(test).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs(int i, int j){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];
        visit[i][j] = true;
        q.offer(new int[]{i,j});
        int cnt = arr[i][j];

        while(!q.isEmpty()) {
            for(int K = 1; K < 2*N; K++){
                int price = M*cnt - (K * K + (K-1) * (K-1)); // 이익
                if(price >= 0) max = Math.max(max, cnt);
                int size = q.size();
                for(int s = 0; s < size; s++) {
                    int[] now = q.poll();
                        
                    for(int d = 0; d < 4; d++) {
                        int nx = now[0] + dx[d];
                        int ny = now[1] + dy[d];
        
                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                        if(visit[nx][ny]) continue;
                        
                        visit[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                        cnt += arr[nx][ny];
                    }
                }
            }
        }
    }
}