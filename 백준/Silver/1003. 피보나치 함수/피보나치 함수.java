import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[41];
        int[] dp2 = new int[41];

        dp[0] = 1;
        dp2[0] = 0;

        dp[1] = 0;
        dp2[1] = 1;

        for(int i = 2; i < 41; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp2[i] = dp2[i-1] + dp2[i-2];
        }

        // 0 -> 1 0, 1 -> 0 1, 2 -> 1 1, 3 -> 1 2, 4-> 2 3, 5 -> 3 5, 6-> 5 8 

        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            
            sb.append(dp[N]).append(" ").append(dp2[N]).append("\n");
        }

        System.out.println(sb);
    }
}