import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, res;
    static List<Integer>[] list, rev;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        rev = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[b].add(a);
            rev[a].add(b);
        }

        res = 0;

        for (int i = 1; i <= N; i++) {
            visit = new boolean[N + 1];
            int sum = check(i, list);

            visit = new boolean[N + 1];
            int sum2 = check(i, rev);

            if (sum + sum2 == N - 1) {
                res++;
            }
        }

        System.out.println(res);
    }

    static int check(int n, List<Integer>[] l) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        int result = 0;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i : l[now]) {
                if (!visit[i]) {
                    result++;
                    visit[i] = true;
                    q.offer(i);
                }
            }
        }
        return result;
    }
}