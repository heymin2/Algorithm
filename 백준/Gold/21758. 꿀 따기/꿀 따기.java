import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, sum;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        sum = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + sum[i-1];
        }

        max = 0;
        int total = 0;

        // case1: 벌통 맨 오른쪽, 벌1 왼쪽 고정
        for(int i = 2; i < N; i++) {
            total = sum[N] - arr[1] - arr[i]; // 1번 벌
            total += sum[N] - sum[i]; // 2번 벌
            max = Math.max(total, max);
        }
      
        // case2: 벌통 맨 왼쪽, 벌1 오른쪽 고정
        for(int i = 2; i < N; i++) {
            total = sum[N-1] - arr[i]; // 1번 벌
            total += sum[N] - (sum[N] - sum[i-1]); // 2번 벌
            max = Math.max(total, max);
        }

        // case3: 벌1 왼쪽, 벌2 오른쪽 고정
        for(int i = 2; i < N; i++) {
            total = sum[i] - arr[1];
            total += sum[N] - sum[i-1] - arr[N];
            max = Math.max(total, max);
        }

        System.out.println(max);
    }
}