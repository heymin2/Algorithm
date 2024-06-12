import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int N;
    static int[] arr, sum;
    static int[] bee;
    static int tong, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        sum = new int[N+1];
        bee = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = arr[i] + sum[i-1];
        }

        max = 0;

        for(int i = 1; i <= N; i++) {
            visit = new boolean[N+1];
            tong = i;
            visit[i] = true;
            select(0, 1);
        }

        System.out.println(max);
    }

    static void select(int idx, int start) {
        if(idx == 2){
            int total = 0;

            int bee1 = bee[0];
            int bee2 = bee[1];

            // 첫번째 벌
            if(bee1 > tong) {
                total = sum[bee1] - sum[tong] - arr[bee1] + arr[tong];

                if(bee2 > tong && bee2 < bee1) {
                    total -= arr[bee2];
                }
            }
            else{
                total = sum[tong] - sum[bee1];

                if(bee2 < tong && bee2 > bee1) {
                    total -= arr[bee2];
                }
            }

            // 두번째 벌
            if(bee2 > tong) {
                total += sum[bee2] - sum[tong] - arr[bee2] + arr[tong];

                if(bee1 > tong && bee1 < bee2) {
                    total -= arr[bee1];
                }
            }
            else{
                total += sum[tong] - sum[bee2];

                if(bee1 < tong && bee1 > bee2) {
                    total -= arr[bee1];
                }
            }

            max = Math.max(total, max);
            return;
        }

        for(int i = start; i <= N; i++) {
            if(!visit[i]){
                visit[i] = true;
                bee[idx] = i;
                select(idx+1, i);
                visit[i] = false;
            }
        }

    }
}