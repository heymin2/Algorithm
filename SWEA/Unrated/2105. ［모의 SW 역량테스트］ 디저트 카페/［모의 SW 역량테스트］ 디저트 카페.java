import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    static int N, arr[][];
    static boolean[] visit;
    static int[] dx = {1, 1, -1, -1};
    static int[] dy = {1, -1, -1, 1};
    static int cx = 0, cy = 0, result;
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];

            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = -1;
            visit = new boolean[101];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(i < N-2 && j > 0 && j < N-1){
                        cx = i; cy = j;
                        dfs(i, j, 0, 0);
                    }
                }
            }
            sb.append("#").append(test).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    static void dfs(int x, int y, int cnt, int d){
        if(d == 3){
            if(cx == x && cy == y){
                result = Math.max(result, cnt);
                return;
            }
        }

        for(int i = 0; i < 2; i++){ // 같은 방향 or 다음 방향
            int nd = (d + i) % 4;
            int nx = x + dx[nd];
            int ny = y + dy[nd];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(visit[arr[nx][ny]]) continue;
            
            visit[arr[nx][ny]] = true;
            dfs(nx, ny, cnt+1, nd);
            visit[arr[nx][ny]] = false;
        }
    }
}
