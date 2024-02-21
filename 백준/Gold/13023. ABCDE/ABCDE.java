import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visit;
    static int N, M, result = 0;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람의 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계의 수

        list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        for (int i = 0; i < N; i++) {
            visit = new boolean[N];
            visit[i] = true;
            dfs(i, 1);
            if (result == 1) {
                break;
            }
        }
        System.out.println(result);
    }

    static void dfs(int cnt, int depth) {
        if (depth == 5) {
            result = 1;
            return;
        }

        for (int idx : list[cnt]) {
            if (!visit[idx]) {
                visit[idx] = true;
                dfs(idx, depth + 1);
                visit[idx] = false;
            }
        }
    }
}