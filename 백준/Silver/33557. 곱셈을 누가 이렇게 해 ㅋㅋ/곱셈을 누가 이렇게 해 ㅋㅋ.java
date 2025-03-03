import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());  // 테스트 개수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Integer.parseInt(st.nextToken());
            long B = Integer.parseInt(st.nextToken());

            String result1 = String.valueOf(A * B);
            String result2 = calc(A, B);

            // 두 결과 비교
            if (result1.equals(result2)) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.print(sb);
    }

    private static String calc(long A, long B) {
        String a = String.valueOf(A);
        String b = String.valueOf(B);
        
        if (a.length() > b.length()) {
            b = "1".repeat(a.length() - b.length()) + b;
        } else if (a.length() < b.length()) {
            a = "1".repeat(b.length() - a.length()) + a;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            sb.append((a.charAt(i) - '0') * (b.charAt(i) - '0')); // 받아올림 없이 일의 자리만 저장
        }

        return sb.toString();
    }
}