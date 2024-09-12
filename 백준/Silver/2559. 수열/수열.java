import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N-M+1];
        int cnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if(i >= M) {
                cnt++;
                sum[cnt] = sum[cnt-1] - arr[i-M];
            }

            sum[cnt] += arr[i];
            
        }

        Arrays.sort(sum);
        System.out.println(sum[sum.length-1]);
    }
}