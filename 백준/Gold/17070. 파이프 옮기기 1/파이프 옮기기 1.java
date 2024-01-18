import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static int result = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1,2,1);
        System.out.println(result);
    }

    static void dfs(int x, int y, int check){
        if(x > N || y > N || arr[x][y] == 1){
            return;
        }

        if(check == 3) {
            if(arr[x-1][y] == 1 || arr[x][y-1] == 1){
                return;
            }
        }

        if(x == N && y == N){
            result++;
            return;
        }

        if(check == 1){ // 가로
            dfs(x, y+1, 1);
            dfs(x+1, y+1, 3);
        }
        else if(check == 2){ // 세로
            dfs(x+1, y, 2);
            dfs(x+1, y+1, 3);
        }
        else if(check == 3){ // 대각선
            dfs(x, y+1, 1);
            dfs(x+1, y, 2);
            dfs(x+1, y+1, 3);
        }
    }
}