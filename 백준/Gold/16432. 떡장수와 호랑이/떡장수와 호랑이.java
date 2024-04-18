import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[];
    static boolean flag = false, visit[][];
    static List<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        arr = new int[N + 1];
        visit = new boolean[N + 1][10];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            for (int j = 0; j < c; j++) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        check(1, 0);
        if (flag) {

            System.out.println(sb);

        } else {
            System.out.println(-1);
        }
    }

    static void check(int cnt, int now) {
        if (cnt == N + 1) {
            for (int i = 1; i <= N; i++) {
                sb.append(arr[i]).append("\n");
            }
            flag = true;
            return;
        }

        for (int v : list[cnt]) {
            if (v != now && !visit[cnt][v]) {
                visit[cnt][v] = true;
                arr[cnt] = v;
                check(cnt + 1, v);

                if (flag)
                    return;
            }
        }
    }
}