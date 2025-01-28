import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int draw, max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][m];
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 1 && !visit[i][j]) {
                    cnt++;
                    draw = 0;
                    dfs(i, j);
                    max = Math.max(draw, max);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n").append(max);
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        if(x < 0 || y < 0 || x >= n || y >= m || arr[x][y] == 0 || visit[x][y]) return;
        visit[x][y] = true;
        draw++;

        dfs(x+1, y);
        dfs(x-1, y);
        dfs(x, y+1);
        dfs(x, y-1);
    }
}