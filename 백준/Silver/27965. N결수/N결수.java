import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long ans = 0;
        long pow10 = 10 % k;
        int next = 10;

        for (int i = 1; i <= n; i++) {
            if (i == next) {
                pow10 = (pow10 * 10) % k;
                next *= 10;
            }
            ans = (ans * pow10 + i) % k;
        }

        System.out.println(ans);
    }
}
