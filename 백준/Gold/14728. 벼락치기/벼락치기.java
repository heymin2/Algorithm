import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] study = new int[N][2];
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            study[i][0] = Integer.parseInt(st.nextToken()); // 공부시간
            study[i][1] = Integer.parseInt(st.nextToken()); // 배점
        }

        int[] dp = new int[T+1];
        for(int i = 0; i < N; i++) {
            for(int j = T; j >= 0; j--) {
                if(j - study[i][0] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - study[i][0]] + study[i][1]);
                }
            }
        }

        System.out.println(dp[T]);
    }
}