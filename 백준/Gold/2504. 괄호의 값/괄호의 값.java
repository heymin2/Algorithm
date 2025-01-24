import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        int result = 0;

        int cnt = 1;
        for(int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if(now == '(') {
                stack.push('(');
                cnt *= 2;
            }
            else if(now == '[') {
                stack.push('[');
                cnt *= 3;
            }
            else if(now == ')') {
                if(stack.isEmpty() || !stack.contains('(')) {
                    result = 0;
                    break;
                }
                else if(input.charAt(i-1) == '(') {
                    result += cnt;
                }
                cnt /= 2;
                stack.pop();
            }
            else if(now == ']') {
                if(stack.isEmpty() || !stack.contains('[')) {
                    result = 0;
                    break;
                }
                else if(input.charAt(i-1) == '[') {
                    result += cnt;
                }
                cnt /= 3;
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            result = 0;
        }

        System.out.println(result);
    }
}