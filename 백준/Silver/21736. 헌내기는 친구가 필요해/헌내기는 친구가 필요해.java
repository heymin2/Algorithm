import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char[][] arr;
    static boolean[][] visit;
    static int check = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visit = new boolean[N][M];

        int x = 0, y = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j);

                if(arr[i][j] == 'I'){
                    x = i;
                    y = j;
                }
            }
        }

        dfs(x,y);

        if(check == 0){
            System.out.println("TT");
        }
        else{
            System.out.println(check);
        }
    }

    static void dfs(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= M || visit[x][y] || arr[x][y] == 'X'){
            return;
        }

        if(arr[x][y] == 'P'){
            check++;
        }

        visit[x][y] = true;

        dfs(x+1, y);
        dfs(x, y+1);
        dfs(x-1, y);
        dfs(x, y-1);
    }
}