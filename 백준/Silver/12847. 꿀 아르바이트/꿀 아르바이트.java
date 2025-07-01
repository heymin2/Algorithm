import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 월세내기 전날
        int m = Integer.parseInt(st.nextToken()); // 최대 일 가능

        int[] money = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            sum += money[i];
            if (i >= m) {
                sum -= money[i - m];
            }
            if (i >= m - 1) {
                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }
}