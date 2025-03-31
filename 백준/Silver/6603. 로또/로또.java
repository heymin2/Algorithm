import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] arr, check;
    static boolean[] visit;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            arr = new int[k];
            visit = new boolean[k];
            for(int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            check = new int[6];
            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int idx, int cnt) {
        if(idx == 6) {
            for(int i = 0; i < 6; i++) {
                sb.append(check[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = cnt; i < k; i++) {
                check[idx] = arr[i];
                dfs(idx+1, i+1);
        }
    }
}