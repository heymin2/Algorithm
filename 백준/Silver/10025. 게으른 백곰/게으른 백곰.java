import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] ice = new int[1_000_001];
        int maxPos = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            ice[x] += g;
            maxPos = Math.max(maxPos, x);
        }

        int range = 2 * K + 1;
        int sum = 0;
        int maxSum = 0;

        for (int i = 0; i < range && i <= maxPos; i++) {
            sum += ice[i];
        }
        maxSum = sum;

        for (int i = range; i <= maxPos; i++) {
            sum += ice[i];
            sum -= ice[i - range];
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}