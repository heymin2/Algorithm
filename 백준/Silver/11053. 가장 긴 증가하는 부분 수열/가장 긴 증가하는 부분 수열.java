import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[0] = Integer.parseInt(st.nextToken());
        int max = 1; // 개수

        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (dp[max - 1] < num) {
                dp[max] = num;
                max++;
            } else if (dp[max - 1] == num) {
                continue;
            } else {
                int left = 0;
                int right = max;
                while (left < right) {
                    int mid = (left + right) / 2;

                    if (dp[mid] < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                dp[right] = num;
            }
        }

        System.out.println(max);
    }
}
