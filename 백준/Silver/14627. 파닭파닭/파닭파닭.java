import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        long[] arr = new long[S];
        long left = 1;
        long right = 0;
        long result = 0;
        long sum = 0;

        for(int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            right = Math.max(right, arr[i]);
            sum += arr[i];
        }

        while(left <= right) {
            long mid = (left + right) / 2;
            
            long count = 0;
            for(int i = 0; i < S; i++) {
                count += arr[i] / mid;
            }

            if(count >= C) {
                result = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(sum - result*C);
	}
}