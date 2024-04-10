import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int N, B, top, arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            top = Integer.MAX_VALUE;
            dfs(0, 0);
            sb.append("#").append(test).append(" ").append(top - B).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int cnt, int sum) {
        if(sum >= B){
            top = Math.min(top, sum);
            return;
        }

        if(cnt == N){
            if(sum >= B){
                top = Math.min(top, sum);
            }
            return;
        }

        dfs(cnt+1, sum + arr[cnt]);
        dfs(cnt+1, sum);
    }
}