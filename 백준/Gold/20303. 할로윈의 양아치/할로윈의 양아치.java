import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] parent, candy, count;
    static List<v> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        candy = new int[N+1];
        count = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
            count[i] = 1;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        sum(N);

        for(int i = 1; i <= N; i++) {
            if(parent[i] == i) {
                list.add(new v(count[i], candy[i]));
            }
        }

        int[][] dp = new int[list.size() + 1][K];
        for (int i = 1; i <= list.size(); i++) {
            for (int j = 0; j < K; j++) {
                if (list.get(i - 1).cnt <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - list.get(i - 1).cnt] + list.get(i - 1).sum);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        System.out.println(dp[list.size()][K - 1]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a > b) parent[b] = a;
        else parent[a] = b;
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void sum(int N) {
        for(int i = 1; i <= N; i++) {
            if(parent[i] != i) {
                int p = find(i);
                candy[p] += candy[i];
                count[p] += count[i];
            }
        }
    }
}

class v{
    int cnt, sum;

    public v(int cnt, int sum) {
        this.cnt = cnt;
        this.sum = sum;
    }
}