import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        String[] dp = new String[M+1];
        Arrays.fill(dp, "-1");

        String result = "0";
        for(int i = 0; i < N; i++) {
            if(arr[i] > M) continue;
            dp[arr[i]] = Integer.toString(i);
        }

        for(int i = 0; i <= M; i++) {
            if(dp[i] != "-1") {
                for(int j = 0; j < N; j++) {
                    if(i + arr[j] <= M) {
                        String now = dp[i] + Integer.toString(j);
                        BigInteger num1 = new BigInteger(now);
                        BigInteger num2 = new BigInteger(dp[i+arr[j]]);

                        int value = num1.compareTo(num2);

                        if(value > 0) {
                            dp[i + arr[j]] = now;
                        }
                    }
                }
            }
        }

        for(String s : dp) {
            BigInteger num1 = new BigInteger(s);
            BigInteger num2 = new BigInteger(result);

            int value = num1.compareTo(num2);
            if(value > 0) result = s;
        }

        System.out.println(result);
    }
}