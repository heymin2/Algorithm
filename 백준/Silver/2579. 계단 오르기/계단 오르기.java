import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[301];

        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[301];

        dp[1] = arr[1]; // 1
        dp[2] = arr[1] + arr[2]; // 1 2
        dp[3] = Math.max(arr[1], arr[2]) + arr[3]; // 1 3, 2 3
    
        for(int i = 4; i <= n; i++){
            dp[i] = Math.max(dp[i-3] +arr[i-1], dp[i-2]) + arr[i];            
        }

        System.out.println(dp[n]);
    }
}