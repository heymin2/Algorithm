import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int result = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(-1);

        for(int i = 0; i < N; i++) {
            char now = input.charAt(i);

            if(now == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if(!stack.isEmpty()) {
                    result = Math.max(result, i - stack.peek());
                }
                else {
                    stack.push(i);
                }
            }
        }

        System.out.println(result);
    }
}