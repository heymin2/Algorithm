import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A);

        int left = 0;
        int right = 1;

        int result = Integer.MAX_VALUE;

        while(right < N && left <= right) {
            int value = A[right] - A[left];

            if(value < M) {
                right++;
            }
            else if(value == M) {
                result = M;
                break;
            }
            else {
                result = Math.min(value, result);
                left++;
            }
        }
        System.out.println(result);
    }
}