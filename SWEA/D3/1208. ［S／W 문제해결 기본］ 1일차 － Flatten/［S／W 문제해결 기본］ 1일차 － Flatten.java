import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		int T = 10;
        int max = 100;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[max];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < max; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < N; j++) {
                Arrays.sort(arr);
                arr[0]++;
                arr[arr.length - 1]--;

            }
            Arrays.sort(arr);
            sb.append("#").append(i).append(" ").append(arr[arr.length - 1] - arr[0]).append("\n");
        }
        System.out.println(sb);
	}
}