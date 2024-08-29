import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int [][] dp = new int[N+1][M+1];

        for(int j = 1; j <= M; j++) {
            dp[1][j] = 1;
        }

        for(int i = 2; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
            }
        }

        System.out.println(dp[N][M]);
    }
}