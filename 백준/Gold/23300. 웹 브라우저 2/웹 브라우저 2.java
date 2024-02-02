import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int cnt = -1;
        Stack<Integer> back = new Stack<>();
        Stack<Integer> front = new Stack<>();
        String input;

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            input = st.nextToken();

            if (input.equals("B") && !back.isEmpty()) {
                front.push(cnt);
                cnt = back.pop();
            }

            else if (input.equals("F") && !front.isEmpty()) {
                back.push(cnt);
                cnt = front.pop();
            }

            else if (input.equals("A")) {
                int num = Integer.parseInt(st.nextToken());

                front.clear();

                if (cnt != -1) {
                    back.push(cnt);
                }
                cnt = num;
            }

            else if (input.equals("C")) {
                if (back.size() > 1) {
                    int check = back.peek();
                    int length = back.size() - 2;
                    for (int j = length; j >= 0; j--) {
                        if (check == back.get(j)) {
                            back.remove(j);
                        } else {
                            check = back.get(j);
                        }

                    }
                }
            }
        }

        sb.append(cnt).append("\n");
        if (back.isEmpty()) {
            sb.append(-1);
        } else {
            while (!back.isEmpty()) {
                sb.append(back.pop()).append(" ");
            }
        }

        sb.append("\n");

        if (front.isEmpty()) {
            sb.append(-1);
        } else {
            while (!front.isEmpty()) {
                sb.append(front.pop()).append(" ");
            }
        }

        System.out.println(sb);
    }
}