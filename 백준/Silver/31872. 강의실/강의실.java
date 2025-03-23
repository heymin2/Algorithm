import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] sum = new int[N];

        sum[0] = arr[0];

        for(int i = 1; i < N; i++) {
            sum[i] = Math.abs(arr[i] - arr[i-1]);
        }

        Arrays.sort(sum);

        int result = 0;
        for(int i = 0; i < N-K; i++) {
            result += sum[i];
        }

        System.out.println(result);
    }
}