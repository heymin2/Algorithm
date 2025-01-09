import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(; T > 0; T--) {
            int N = Integer.parseInt(br.readLine()); // 동전의 가지수
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine()); // 만들어야하는 금액

            int[] dp = new int[M+1];
            dp[0] = 1;
            
            for(int i = 0; i < N; i++) {
                for(int j = arr[i]; j <= M; j++) {
                    dp[j] = dp[j] + dp[j-arr[i]];
                }
            }

            sb.append(dp[M]).append("\n");
        }

        System.out.println(sb);
    }
}