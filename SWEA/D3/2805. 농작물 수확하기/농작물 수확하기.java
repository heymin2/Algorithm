import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution
{
    static int N;
    static int[][] arr;
    static int sum;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N][N];
            sum = 0;

            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < N; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }
            re(0, N / 2, N / 2);
            sb.append("#").append(test).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);
    }

    static void re(int cnt, int start, int end) {
        if (cnt == N) {
            return;
        }
        for (int s = start; s <= end; s++) {
            sum += arr[cnt][s];
        }
        if (cnt < N / 2) {
            re(cnt + 1, start - 1, end + 1);
        } else {
            re(cnt + 1, start + 1, end - 1);
        }
    }
}