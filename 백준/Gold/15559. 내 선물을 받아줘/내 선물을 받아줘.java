import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static int[][] visit;
    static int cnt, N, M, idx;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visit = new int[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();

            for(int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        cnt = 0;
        idx = 1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visit[i][j] == 0){
                    dfs(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    static void dfs(int x, int y) {
        visit[x][y] = idx;

        int nx = x;
        int ny = y;

        switch (arr[x][y]) {
            case 'S':
                nx += 1;
                break;
            
            case 'W':
                ny -= 1;
                break;

            case 'N':
                nx -= 1;
                break;

            case 'E':
                ny += 1;
                break;
        
            default:
                break;
        }

        if(visit[nx][ny] == 0){
            dfs(nx, ny);
        }
        else{
            if(visit[nx][ny] == idx) {
                cnt++;
            }
            idx++;
        }
    }
}