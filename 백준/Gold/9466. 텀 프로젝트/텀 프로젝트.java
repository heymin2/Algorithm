import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result, arr[];
    static boolean[] visit, check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++) {
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            arr = new int[n+1];
            visit = new boolean[n+1];
            check = new boolean[n+1];

            for(int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result = 0;

            for(int i = 1; i <= n; i++) {
                if(!check[i]) dfs(i);
            }

            sb.append(n - result).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int num) {
        if(check[num]) return;
        if(visit[num]) {
            check[num] = true;
            result++;
        }

        visit[num] = true;
        dfs(arr[num]);
        check[num] = true;
        visit[num] = false;
    }
}