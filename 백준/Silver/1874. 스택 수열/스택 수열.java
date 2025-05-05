import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> st = new ArrayDeque<>();
        int num = 1;
        boolean check = true;

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            while (num <= target) {
                st.push(num++);
                sb.append("+\n");
            }

            if (st.peek() == target) {
                st.pop();
                sb.append("-\n");
            } else {
                check = false;
                break;
            }
        }

        if (check) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}
