import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] prefixSum = new int[N + 2]; // "Yes"의 누적합을 저장할 배열
        boolean[] answers = new boolean[N + 2]; // 각 질문의 답을 저장하는 배열 (true: Yes, false: No)

        // 첫 번째 질문은 항상 Yes라고 가정 (이 문제의 첫 번째 답)
        answers[1] = true;
        prefixSum[1] = 1;  // 첫 번째 질문의 답이 Yes이므로 prefixSum[1]은 1

        for (int i = 2; i <= N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 구간 [x, y]의 "Yes" 개수를 구함
            int sumInRange = prefixSum[y] - prefixSum[x - 1];

            if (c == 1) {
                // 구간 [x, y]의 모든 값이 Yes여야 현재 질문이 Yes
                if (sumInRange == (y - x + 1)) {
                    answers[i] = true;
                    sb.append("Yes").append("\n");
                } else {
                    answers[i] = false;
                    sb.append("No").append("\n");
                }
            } else {
                // 구간 [x, y]의 모든 값이 No여야 현재 질문이 Yes
                if (sumInRange == 0) {
                    answers[i] = true;
                    sb.append("Yes").append("\n");
                } else {
                    answers[i] = false;
                    sb.append("No").append("\n");
                }
            }

            // prefixSum 업데이트
            prefixSum[i] = prefixSum[i - 1] + (answers[i] ? 1 : 0);
        }

        System.out.println(sb);
    }
}