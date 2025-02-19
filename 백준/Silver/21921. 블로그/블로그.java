import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int total = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if(i < X) total += arr[i];
        }

        int[] sum = new int[N-X+1];
        sum[0] = total;

        int left = 0;
        int right = X;

        for(int i = 1; i < N-X+1; i++) {
            total = total + arr[right] - arr[left];
            sum[i] = total;
            right++; left++;
        }

        Arrays.sort(sum);

        int result = sum[N-X];

        if(result == 0) System.out.println("SAD");
        else {
            int cnt = 0;
            for(int i = N-X; i >= 0; i--) {
                if(sum[i] == result) cnt++;
                else break; 
            }
    
            StringBuilder sb = new StringBuilder();
            sb.append(result).append("\n").append(cnt);
    
            System.out.println(sb);
        }
	}
}
