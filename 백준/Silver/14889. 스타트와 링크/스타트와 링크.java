import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, min= Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        selected = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        select(0);
        System.out.println(min);
    }

    static void select(int cnt) {
        if (cnt == n) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (selected[i]) {
                    a.add(i);
                } else {
                    b.add(i);
                }
            }

            if (a.size() == n/2 && b.size() <= n/2) {
                int result = Math.abs(calculate(a) - calculate(b));
                min = Math.min(min, result);
                return;
            }

            return;
        }

        selected[cnt] = true;
        select(cnt + 1);
        selected[cnt] = false;
        select(cnt + 1);
    }

    static int calculate(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int x = list.get(i);
                int y = list.get(j);
                sum += arr[x][y];
                sum += arr[y][x];
            }
        }
        return sum;
    }
}