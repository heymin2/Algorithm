import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, result = 0;
    static char[][] arr;
    static boolean flag;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];

        for(int i = 0; i < R; i++){
            String str = br.readLine();
            for(int j = 0; j < C; j++){
                arr[i][j]= str.charAt(j);
            }
        }

        for(int i = 0; i < R; i++){
            flag = false;
            dfs(i, 0);
        }

        System.out.println(result);
    }

    static void dfs(int x, int y){
        if(y == C-1 && !flag){
            flag = true;
            result++;
            return;
        }

        if(x < 0 || y < 0 || x >= R || y >= C || arr[x][y] == 'x') return;

        if(flag) return;
        
        arr[x][y] = 'x';

        dfs(x-1, y+1);
        dfs(x, y+1);
        dfs(x+1, y+1);
    }
}