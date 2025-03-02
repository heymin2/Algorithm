import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        char[] arr = new char[N];
        String input = br.readLine();
        for(int i = 0; i < N; i++) {
            arr[i] = input.charAt(i);
        }

        boolean[] check = new boolean[N];
        int result = 0;
        for(int i = 0; i < N; i++) {
            if(arr[i] == 'P') {
                int start = Math.max(i-K, 0);
                int end = Math.min(i+K, N-1);

                for(int j = start; j <= end; j++) {
                    if(arr[j] == 'H' && !check[j]) {
                        check[j] = true;
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}