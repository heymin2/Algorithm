import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static boolean[][] visit;
    static int r,c;
    static int check;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        arr = new int[5][5];
        visit = new boolean[5][5];

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        dfs(r,c,0,0);
        System.out.println(check);

    }

    static void dfs(int x, int y, int cnt, int apple) {
        if(arr[x][y] == 1){
            apple++;
        }

        if(cnt == 3) {
            if(apple >= 2) {
                check = 1;
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
            if(visit[nx][ny] || arr[nx][ny] == -1) continue;

            visit[x][y] = true;
            dfs(nx, ny, cnt+1, apple);
            visit[x][y] = false;
        }
    }
}