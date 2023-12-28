import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] w = new int[N+1];
        int[] v = new int[N+1];

        for(int i = 1; i <= N; i++){
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();

        }

        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){
                if(w[i] > j){
                    dp[i][j] = dp[i-1][j];
                } 
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}