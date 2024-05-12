import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class Main {
    static int N, K, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(K >= N) {
            System.out.println(0);
        }
        else{
            Arrays.sort(arr);

            int[] diff = new int[N-1];
            for(int i = 0; i < N-1; i++) {
                diff[i] = arr[i+1] - arr[i];
            }

            Arrays.sort(diff);

            int sum = 0;

            for(int i = 0; i < N-K; i++) {
                sum += diff[i];
            }

            System.out.println(sum);
        }
    }
}