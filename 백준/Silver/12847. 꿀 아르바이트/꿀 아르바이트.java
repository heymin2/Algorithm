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
        for(int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        long max = 0;
        for(int i = 0; i < m; i++) {
            max += money[i];
        }

        long result = max;
        for(int i = m; i < n; i++) {
            result -= money[i - m];
            result += money[i];
            
            max = Math.max(max, result);
        }

        System.out.println(max);
    }
}