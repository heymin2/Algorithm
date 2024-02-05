import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();

        for (int i = 1; i <= N; i++) {
            int top = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty()) {
                if (stack.peek() > top) {
                    sb.append(index.peek()).append(" ");
                    break;
                } else {
                    stack.pop();
                    index.pop();
                }
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");

            }
            stack.push(top);
            index.push(i);
        }

        System.out.println(sb);
    }
}