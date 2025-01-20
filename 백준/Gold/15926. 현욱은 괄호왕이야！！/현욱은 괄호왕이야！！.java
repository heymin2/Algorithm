import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int result = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int lastInvalid = -1; // 마지막으로 유효하지 않은 괄호의 위치

        for (int i = 0; i < N; i++) {
            char now = input.charAt(i);

            if (now == '(') {
                stack.push(i); // 여는 괄호의 인덱스를 저장
            } else {
                if (stack.isEmpty()) {
                    // 닫는 괄호지만 짝이 없으므로 유효하지 않음
                    lastInvalid = i;
                } else {
                    stack.pop(); // 짝이 맞는 여는 괄호를 제거
                    if (stack.isEmpty()) {
                        // 스택이 비어 있으면 마지막 유효하지 않은 괄호 이후부터 현재 위치까지 유효
                        result = Math.max(result, i - lastInvalid);
                    } else {
                        // 스택이 비어 있지 않으면 현재 스택의 최상단 인덱스 이후가 유효
                        result = Math.max(result, i - stack.peek());
                    }
                }
            }
        }

        System.out.println(result);
    }
}