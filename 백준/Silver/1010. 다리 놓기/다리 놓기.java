import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] dp = new int[M+1][M+1];
            for(int i = 1; i <= M; i++) {
                dp[i][0] = 1;
                dp[i][i] = 1;
            }

            for(int i = 2; i <= M; i++) {
                for(int j = 1; j <= i; j++) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
            
            sb.append(dp[M][N]).append("\n");
        }
        System.out.println(sb);
    }
}