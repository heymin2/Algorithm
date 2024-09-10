import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] prefixSum = new int[N + 2];

        prefixSum[1] = 1;

        for (int i = 2; i <= N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            boolean flag = false;

            int sumInRange = prefixSum[y] - prefixSum[x - 1];

            if (c == 1) {
                if (sumInRange == (y - x + 1)) {
                    flag = true;
                }
            } else {
                if (sumInRange == 0) {
                    flag = true;
                }
            }

            prefixSum[i] = prefixSum[i - 1] + (flag ? 1 : 0);
            sb.append(flag ? "Yes\n" : "No\n");
        }

        System.out.println(sb);
    }
}