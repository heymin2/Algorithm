import java.util.*;
import java.io.*;

public class Main {
    static int N, M, V;
    static int[] dfs;
    static boolean[] flag;
    static boolean[][] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new boolean[N+1][N+1];
        dfs = new int[N];
        flag = new boolean[N+1];


        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = true;
        }

        dfs(V);
        sb.append("\n");
        bfs(V);
        System.out.println(sb);
    }

    static void dfs(int start) {
        flag[start] = true;
        sb.append(start).append(" ");

        for(int i = 1; i <= N; i++) {
            if(!flag[i] && arr[start][i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        flag = new boolean[N+1];
        flag[start] = true;

        while(!q.isEmpty()) {
            int now = q.poll();
            sb.append(now).append(" ");

            for(int i = 1; i <= N; i++) {
                if(!flag[i] && arr[now][i]) {
                    flag[i] = true;
                    q.add(i);
                }
            }
        }
    }
}