import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int w,h;
    static int[][] arr;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0){
                break;
            }

            arr = new int[h][w];
            visit = new boolean[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < w; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(arr[i][j] == 1 && !visit[i][j]){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y){
        if(x < 0 || y < 0 || x >= h || y >= w || visit[x][y] || arr[x][y] == 0) return;

        visit[x][y] = true;

        dfs(x+1, y);
        dfs(x-1, y);
        dfs(x, y+1);
        dfs(x, y-1);
        dfs(x+1, y+1);
        dfs(x+1, y-1);
        dfs(x-1, y-1);
        dfs(x-1, y+1);
    }
}