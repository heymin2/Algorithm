import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, dp[], tmp[], arr[][];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);

        dp = new int[N+1];
        tmp = new int[N];
        int len = 1;
        dp[1] = arr[N-1][1];
        tmp[N-1] = 1;

        for(int i = N-2; i >= 0; i--) {
            if(arr[i][1] < dp[len]) {
                dp[++len] = arr[i][1];
                tmp[i] = len;
            }
            else {
                int idx = search(1, len, arr[i][1]);
                dp[idx] = arr[i][1];
                tmp[i] = idx;
            }
        }

        sb.append(N-len).append("\n");

        int idx = len;
        for(int i = 0; i < N; i++){
            if(tmp[i] == idx) idx--;
            else sb.append(arr[i][0]).append("\n");
        }  
         
        System.out.println(sb);
    }

    static int search(int start, int end, int num) {
        if(start == end) return start;

        int mid = (start + end) / 2;
        if(dp[mid] <= num) return search(start, mid, num);
        else return search(mid+1, end, num);
    }
}