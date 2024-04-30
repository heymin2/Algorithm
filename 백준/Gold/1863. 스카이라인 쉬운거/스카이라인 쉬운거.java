import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            arr[i] = B; // 의문
        }
       
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int result = 0;

        for(int i = 0; i <= N; i++) {
            while(!stack.isEmpty() && stack.peekFirst() > arr[i]) {
                result++;
                stack.pollFirst();
            }

            if(!stack.isEmpty() && stack.peekFirst() == arr[i]) {
                continue;
            }

            stack.push(arr[i]);
        }

        System.out.println(result);
    }
}