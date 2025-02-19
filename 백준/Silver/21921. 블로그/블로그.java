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
        int result = sum[0];
        int cnt = 1;

        for(int i = 1; i < N-X+1; i++) {
            total += arr[right++] - arr[left++];
            sum[i] = total;

            if(sum[i] > result) {
                result = sum[i];
                cnt = 1;
            }
            else if(sum[i] == result) cnt++;
        }

        if(result == 0) System.out.println("SAD");
        else {
            StringBuilder sb = new StringBuilder();
            sb.append(result).append("\n").append(cnt);
    
            System.out.println(sb);
        }
	}
}