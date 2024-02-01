import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N;
    static long min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][2];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        re(0, 1, 0);
        System.out.println(min);
    }

    static void re(int idx, int S, int B) {
        if (idx == N) {
            if (S == 1 && B == 0) {
                return;
            }
            min = Math.min(min, Math.abs(S - B));
            return;
        }

        re(idx + 1, S * arr[idx][0], B + arr[idx][1]);
        re(idx + 1, S, B);
    }
}