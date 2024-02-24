import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, dp, tmp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N];
        tmp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        int result = 0;
		int resultIdx = 0;

        for(int i = 1; i < N; i++){
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
                    tmp[i] = j;
                    dp[i] = dp[j] + 1;
                }
            }
            if(dp[i] > result){
				result = dp[i];
				resultIdx = i;
			}
        }

        Arrays.sort(dp);
        sb.append(dp[N-1]).append("\n");

        if(N == 1){
            sb.append(arr[0]);
        }

        int[] answer = new int[result];
		int index = resultIdx;

		for(int i = result - 1; i >= 0; i--) {
			answer[i] = arr[index];
			index = tmp[index]; 
		}

        for(int i = 0; i < result; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}