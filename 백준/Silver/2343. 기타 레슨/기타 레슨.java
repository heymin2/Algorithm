import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int left = 0, right = 0, sum = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            sum += arr[i];
        }

        right = sum;

        while(left <= right) {
            int sum2 = 0;
            int mid = (left + right) / 2;
            int count = 1;

            for(int i = 0; i < N; i++) {
                sum2  += arr[i];
                if(sum2 > mid) {
                    sum2 = arr[i];
                    count++;
                }
            }

            if(count <= M) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}