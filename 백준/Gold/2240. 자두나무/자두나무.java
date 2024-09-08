import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int cnt = 1;

        int[] arr = new int[T+1];
        int[][] dp = new int[T+1][W+1];

        for(int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int t = 1; t <= T; t++) {
            dp[t][0] = dp[t-1][0];
            if(arr[t] == cnt) {
                dp[t][0] += 1;
            }
        }

        for(int w = 1; w <= W; w++) {
            cnt ^= 3; // 1 -> 2, 2 -> 1

            for(int t = 1; t <= T; t++){
                if (arr[t] == cnt) {
                    dp[t][w] = Math.max(dp[t-1][w] + 1, dp[t][w-1] + 1);
                }
                else {
                    dp[t][w] = Math.max(dp[t-1][w], dp[t][w-1]);
                }
            }

        }

        System.out.println(dp[T][W]);
    }
}

// T초동안 자두 떨어지는데, 최대 W번 움직임 -> 자두 받을수있는 최대 개수 구하기