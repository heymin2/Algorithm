import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int D, W, K, arr[][], tmp[][], min;
    static int[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[D][W];
            tmp = new int[D][W];
            visit = new int[D];

            for (int i = 0; i < D; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = D;

            if (K == 1) {
                min = 0;
            } else {
                select(0, 0);
            }

            sb.append("#").append(test).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    static void select(int idx, int cnt) {
        if (cnt == D) {

            int sum = 0;

            for (int i = 0; i < cnt; i++) {
                if (visit[i] != 2)
                    sum++;
            }

            if (sum > min) {
                return;
            }

            if (change()) {
                min = Math.min(min, sum);
            }

            return;
        }

        for (int i = 0; i < 3; i++) {
            visit[cnt] = i;
            select(i + 1, cnt + 1);
        }
    }

    static boolean change() {
        for (int i = 0; i < D; i++) {
            for (int j = 0; j < W; j++) {
                if (visit[i] == 2) {
                    tmp[i][j] = arr[i][j];
                } else {
                    tmp[i][j] = visit[i];
                }
            }
        }

        return check();
    }

    static boolean check() {
        for (int j = 0; j < W; j++) {
            int cntA = 0;
            int cntB = 0;
            int maxA = 0;
            int maxB = 0;
            for (int i = 0; i < D; i++) {
                if (tmp[i][j] == 0) {// A
                    cntA++;
                    cntB = 0;
                    maxA = Math.max(maxA, cntA);
                } else { // B
                    cntB++;
                    cntA = 0;
                    maxB = Math.max(maxB, cntB);
                }
            }

            if (maxA < K && maxB < K) {
                return false;
            }
        }

        return true;
    }
}