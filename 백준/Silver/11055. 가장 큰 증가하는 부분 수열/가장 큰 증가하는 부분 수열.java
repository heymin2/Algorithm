import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];

        for(int i = 1; i < N; i++){
            dp[i] = arr[i];
            for(int j = i-1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[N-1]);
    }
}