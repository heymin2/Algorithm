import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[][], now_chicken[], result = Integer.MAX_VALUE;
    static List<int[]> chicken = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        now_chicken = new int[M]; // 폐업 후 치킨집

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 2) {
                    chicken.add(new int[] { i, j });
                }

                else if (arr[i][j] == 1) {
                    home.add(new int[] { i, j });
                }
            }
        }
        combination(0, 0);

        System.out.println(result);
    }

    static void combination(int cnt, int start) {
        if (cnt == M) {
            result = Math.min(result, checkD());
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            now_chicken[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    static int checkD() {
        int total = 0;
        for (int i = 0; i < home.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                int[] h = home.get(i);
                int[] c = chicken.get(now_chicken[j]);
                int d = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                if (d < min) {
                    min = d;
                }
            }
            total += min;

        }

        return total;
    }
}