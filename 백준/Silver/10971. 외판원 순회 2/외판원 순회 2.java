import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visit;
    static int[][] arr;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visit = new boolean[N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visit[i] = true;
            p(i, 0, 0, i);
        }
        System.out.println(min);

    }

    static void p(int k, int cnt, int sum, int now) {
        if (cnt == N - 1) {
            if (arr[now][k] != 0) {
                sum += arr[now][k];
                min = Math.min(min, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visit[i] && arr[now][i] != 0) {
                visit[i] = true;
                p(k, cnt + 1, sum + arr[now][i], i);
                visit[i] = false;
            }
        }
    }
}