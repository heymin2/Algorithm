import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[2][N+1][3];

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < 3; j++) {
                dp[0][i][j] = dp[0][i-1][j];
                dp[1][i][j] = dp[1][i-1][j];

                if(0 <= j-1) {
                    dp[0][i][j] = Math.min(dp[0][i][j], dp[0][i-1][j-1]);
                    dp[1][i][j] = Math.max(dp[1][i][j], dp[1][i-1][j-1]);
                }

                if(j+1 < 3) {
                    dp[0][i][j] = Math.min(dp[0][i][j], dp[0][i-1][j+1]);
                    dp[1][i][j] = Math.max(dp[1][i][j], dp[1][i-1][j+1]);
                }

                dp[0][i][j] += arr[i-1][j];
                dp[1][i][j] += arr[i-1][j];
            }
        }



        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++) {
            min = Integer.min(min, dp[0][N][i]);
            max = Integer.max(max, dp[1][N][i]);
        }

        sb.append(max).append(" ").append(min);
        System.out.println(sb);
    }
}