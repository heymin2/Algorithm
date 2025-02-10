import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] L = new int[N];
        int[] J = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) { // 체력 
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) { // 기쁨
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101];

        for(int i = 0; i < N; i++) {
            for(int j = 100; j > 0; j--) {
                if(j > L[i]) {
                    dp[j] = Math.max(dp[j], dp[j-L[i]] + J[i]);
                }
            }
        }

        System.out.println(dp[100]);
    }
}