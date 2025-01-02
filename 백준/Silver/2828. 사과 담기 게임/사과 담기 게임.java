import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 몇개까지
        int cnt = 1; // 현재 위치
        int result = 0; // 이동 횟수

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int value = Integer.parseInt(br.readLine()); // 떨어지는 위치

            if(cnt <= value && value < cnt+M) continue;
            else if(value > cnt) {
                int plus = value - (cnt+M-1);
                cnt += plus;
                result += plus;
            }
            else if(value < cnt) {
                int plus = cnt - value;
                cnt -= plus;
                result += plus;
            }
        }

        System.out.println(result);
    }
}