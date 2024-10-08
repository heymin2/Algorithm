import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;
    static int[] select;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        check = new boolean[N+1];
        select = new int[M];

        select(0);

        System.out.println(sb);
    }

    static void select(int cnt) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                sb.append(select[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i = 1; i <= N; i++) {
            if(!check[i]) {
                select[cnt] = i;
                check[i] = true;
                select(cnt+1);
                check[i] = false;
            }
           
        }
    }
}