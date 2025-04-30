import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] arr;
    static boolean[][] visit;
    static int s, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        int o = 0, v = 0;

        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visit[i][j]) {
                    s = 0; w = 0;
                    dfs(i, j);

                    if(s > w) {
                        o += s;
                    }
                    else {
                        v += w;
                    }
                }
            }
        }

        System.out.println(o + " " + v);
    }

    static void dfs(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= M || visit[x][y] || arr[x][y] == '#') return;

        visit[x][y] = true;
        if(arr[x][y] == 'o') s++;
        if(arr[x][y] == 'v') w++;

        dfs(x+1, y);
        dfs(x-1, y);
        dfs(x, y+1);
        dfs(x, y-1);
    }
}