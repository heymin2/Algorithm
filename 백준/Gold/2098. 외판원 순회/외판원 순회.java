import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map, dp;
    static int INF = 16_000_000;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][(1 << N)];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println(dfs(0, 1));
    }

    static int dfs(int city, int visit) {
        if(visit == (1 << N) -1) {
            if(map[city][0] == 0) return INF;
            return map[city][0];
        }

        if(dp[city][visit] != -1) {
            return dp[city][visit];
        }

        dp[city][visit] = INF;

        for(int i = 0; i < N; i++) {
            if((visit & (1 << i)) == 0 && map[city][i] != 0) {
                dp[city][visit] = Math.min(dp[city][visit], dfs(i, visit | (1 << i)) + map[city][i]);
            }
        }

        return dp[city][visit];
    }
}