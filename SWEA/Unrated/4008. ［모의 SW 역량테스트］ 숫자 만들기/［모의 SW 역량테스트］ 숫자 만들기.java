import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	static int N, max, min;
    static int[] op, number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());

            op = new int[4];
            number = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            dfs(1, number[0]);
            sb.append("#").append(test).append(" ").append(max-min).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int cnt, int sum) {
        if(cnt == N){
            min = Math.min(sum, min);
            max = Math.max(max, sum);
            return;
        }

        if(op[0] != 0){
            op[0]--;
            dfs(cnt+1, sum + number[cnt]);
            op[0]++;
        }

        if(op[1] != 0){
            op[1]--;
            dfs(cnt+1, sum - number[cnt]);
            op[1]++;
        }

        if(op[2] != 0){
            op[2]--;
            dfs(cnt+1, sum * number[cnt]);
            op[2]++;
        }

        if(op[3] != 0){
            op[3]--;
            dfs(cnt+1, sum / number[cnt]);
            op[3]++;
        }
    }
}