import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] check;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        int max = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        int result = 0;
        
        for(int k = 0; k <= max; k++) {
            check = new boolean[N][N];
            int cnt = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(arr[i][j] > k && !check[i][j]) {
                        dfs(i, j, k);
                        cnt++;
                    }
                }
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }

    static void dfs(int x, int y, int k) {
        if(x < 0 || y < 0 || x >= N || y >= N || arr[x][y] <= k || check[x][y]) return;

        check[x][y] = true;

        dfs(x+1, y, k);
        dfs(x-1, y, k);
        dfs(x, y+1, k);
        dfs(x, y-1, k);
    }
}