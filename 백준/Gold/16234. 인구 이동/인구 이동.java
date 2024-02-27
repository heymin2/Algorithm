import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, L, R;
    static int[][] arr;
    static boolean[][] visit;
    static List<int[]> nara; 
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i = 0 ; i < N; i++){st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(diff());
    }

    static int diff(){ // 인구 차이
        int result = 0;

        while(true){
            boolean flag = false;
            visit = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visit[i][j]){
                        int sum = check(i,j) / nara.size();

                        if(nara.size() > 1){
                            flag = true;

                            for(int[] now : nara){
                                arr[now[0]][now[1]] = sum;
                            }
                        }
                    }
                }
            }
            if(!flag) return result;
            result++;
        }
    }

    static int check(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        nara = new ArrayList<>();

        q.offer(new int[]{x,y});
        nara.add(new int[]{x,y});
        visit[x][y] = true;
        int sum = arr[x][y];

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int k = 0; k < 4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
    
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny]) continue;
                    
                int d = Math.abs(arr[now[0]][now[1]] - arr[nx][ny]);
    
                if(d >= L && d <= R){
                    q.offer(new int[]{nx,ny});
                    nara.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    sum += arr[nx][ny];
                 }
            }
        }
        return sum;
    }
}