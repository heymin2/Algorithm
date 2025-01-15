import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 얼음 양동이
        int K = Integer.parseInt(st.nextToken()); // 좌우 K만큼 이동 가능

        int[] arr = new int[1_000_001];

        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            arr[x] += g;
        }
       
        int sum = 0;

        for(int i = 0; i < K*2+1; i++) {
            if(i > 1_000_000) break;
            sum += arr[i];
        }

        int max = sum;

        for(int i = K*2+1, j = 0; i <= 1_000_000; i++, j++) {
            sum -= arr[j];
            sum += arr[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}