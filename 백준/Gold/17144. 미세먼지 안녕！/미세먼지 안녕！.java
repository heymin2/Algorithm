import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R,C,T, arr[][];
    static List<int[]> air;
    static List<Dust> dust;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        air = new ArrayList<>();

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            
                if(arr[i][j] == -1){
                    air.add(new int[]{i,j});
                }
            }
        }

        for(int i = 0; i < T; i++){
            dust_diff();
            air_clean();
        }
        
        dust_check();

        int sum = 0;

        for(int i = 0; i < dust.size(); i++){
            sum += dust.get(i).num;
        }

        System.out.println(sum);
    }

    static void dust_diff(){ // 미세먼지 확산
        dust_check();

        for(int i = 0; i < dust.size(); i++){
            Dust d = dust.get(i);
            int cnt = 0;
            int diff = d.num / 5;
            if(diff == 0){
                continue;
            }

            for(int j = 0; j < 4; j++){
                int nx = d.x + dx[j];
                int ny = d.y + dy[j];

                if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if(arr[nx][ny] == -1) continue;

                arr[nx][ny] += diff;
                cnt++;
            }

            arr[d.x][d.y] -= diff * cnt;
        }
    }

    static void dust_check(){ // 미세먼지 있는 곳 체크
        dust = new ArrayList<>();

        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(arr[i][j] > 0){
                    dust.add(new Dust(i, j, arr[i][j]));
                }
            }
        }
    }

    static void air_clean(){ // 공기청정기 작동
        // 위쪽 공기청정 - 반시계
        int hx = air.get(0)[0];
        int hy = air.get(0)[1];

        // 아래로 당기기
        for (int i = hx - 1; i > 0; i--) 
            arr[i][hy] = arr[i-1][hy];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) 
            arr[0][i] = arr[0][i+1];
        // 위로 당기기
        for (int i = 0; i < hx; i++) 
            arr[i][C - 1] = arr[i + 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) 
            arr[hx][i] = arr[hx][i-1];
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        arr[hx][hy+1] = 0;

        // 아래쪽 공기청정기 - 시계
        int lx = air.get(1)[0];
        int ly = air.get(1)[1];

        // 위로 당기기
        for (int i = lx+1; i < R-1; i++) 
            arr[i][ly] = arr[i + 1][ly];
        // 왼쪽으로 당기기
        for (int i = ly; i < C - 1; i++) 
        arr[R-1][i] = arr[R-1][i+1];
        // 아래로 당기기
        for (int i = R - 1; i > lx; i--) 
            arr[i][C-1] = arr[i-1][C-1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) 
        arr[lx][i] = arr[lx][i-1];
       
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        arr[lx][ly+1] = 0;
    }
}

class Dust{
    int x, y, num;

    Dust(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
}