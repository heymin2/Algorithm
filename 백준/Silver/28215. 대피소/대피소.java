import java.util.*;
import java.io.*;

public class Main {
    static int[] x;
    static int[] y;
    static int N, K;
    static final int INF = Integer.MAX_VALUE;
    static int ans = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        x = new int[N];
        y = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> selected = new ArrayList<>();
        generateCombinations(0, 0, selected);
        System.out.println(ans);
    }

    static void generateCombinations(int start, int depth, List<Integer> selected) {
        if (depth == K) {
            ans = Math.min(ans, maxDist(selected));
            return;
        }

        for (int i = start; i < N; i++) {
            selected.add(i);
            generateCombinations(i + 1, depth + 1, selected);
            selected.remove(selected.size() - 1);
        }
    }

    static int maxDist(List<Integer> comb) {
        int result = 0;

        for (int i = 0; i < N; i++) {
            int minDist = INF;

            for (int c : comb) {
                int dist = Math.abs(x[i] - x[c]) + Math.abs(y[i] - y[c]);
                minDist = Math.min(minDist, dist);
            }

            result = Math.max(result, minDist);
        }

        return result;
    }
}