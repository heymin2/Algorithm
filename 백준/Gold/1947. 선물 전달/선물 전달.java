import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[Math.max(3, N+1)];
        dp[2] = 1;

        for(int i = 3; i <= N; i++) {
            dp[i] = ((i-1) * (dp[i-1] + dp[i-2])) % 1_000_000_000;
        }

        System.out.println(dp[N]);
    }
}

// 양방향 교환 -> dp[i-2], 단방향 교환 -> dp[i-1]