import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long idx = N % 1_500_000;

        long[] dp = new long[(int) idx + 1];
        dp[0] = 0;

        if (N > 0) {
            dp[1] = 1;

            for (int i = 2; i <= idx; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1_000_000;
            }
        }
        System.out.println(dp[(int) idx]);
    }
}