import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        arr = new int[M];
        check = new boolean[N+1];

        sb = new StringBuilder();
        re(0, 1);
        System.out.println(sb);
    }

    static void re(int idx, int cnt) {
        if(idx == M) {
            for(int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = cnt; i <= N; i++) {
            arr[idx] = i;
            re(idx+1, i);
        }
    }
}