import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[][], copy_arr[][], result = Integer.MAX_VALUE;
    static List<info> list;
    static int[] dx = {-1,0,1,0}; // 시계 방향
    static int[] dy = {0,1,0,-1};
    static int[] cctv;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        list = new ArrayList();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            
                if(arr[i][j] != 0 && arr[i][j] != 6){
                    list.add(new info(i, j, arr[i][j]));
                }
            }
        }

        cctv = new int[list.size()];

        p(0);

        System.out.println(result);
    }

    static void p(int cnt){
        if(cnt == list.size()){
            copy_arr = copy();

            for(int i = 0; i < list.size(); i++){
                d(list.get(i), cctv[i]);
            }

            result = Math.min(result, getCnt());
            return;
        }

        info c = list.get(cnt);

        for(int i = 0; i < 4; i++){
            if(c.idx == 2 && i == 2){
                break;
            }

            if(c.idx == 5 && i == 1){
                break;
            }

            cctv[cnt] = i;
            p(cnt+1);
        }
    }

    static void d(info c, int d){
        if(c.idx == 1){
            if(d  == 0){
                watch(c, 0);
            }
            else if(d == 1){
                watch(c, 1);
            }
            else if(d == 2){   
                watch(c, 2);
            }
            else{
                watch(c, 3);
            }
        }
        else if(c.idx == 2){
            if(d == 0){
                watch(c, 0);
                watch(c, 2);
            }
            else{
                watch(c, 1);
                watch(c,3);
            }
        }
        else if(c.idx == 3){
            if(d  == 0){
                watch(c, 0);
                watch(c, 1);
            }
            else if(d == 1){
                watch(c, 1);
                watch(c, 2);
            }
            else if(d == 2){
                watch(c, 2);
                watch(c, 3); 
            }
            else{
                watch(c, 3); 
                watch(c, 0);
            }
        }
        else if(c.idx == 4){
            if(d  == 0){
                watch(c, 0);
                watch(c, 1);
                watch(c, 2);
            }
            else if(d == 1){
                watch(c, 1);
                watch(c, 2);
                watch(c, 3);
            }
            else if(d == 2){
                watch(c, 2);
                watch(c, 3); 
                watch(c, 0);
            }
            else{
                watch(c, 3); 
                watch(c, 0);
                watch(c, 1);
            }
        }
        else if(c.idx == 5){
            watch(c, 0);
            watch(c, 1);
            watch(c, 2);
            watch(c, 3); 
        }
    }

    static void watch(info c, int d){
        int nx = c.x + dx[d];
        int ny = c.y + dy[d];

        while(true){
            if(nx < 0 || ny < 0 || nx >= N || ny >= M || copy_arr[nx][ny] == 6) break;

            if(copy_arr[nx][ny] == 0){
                copy_arr[nx][ny] = -1;
            }

            nx += dx[d];
            ny += dy[d];
        }
    }

    static int getCnt(){
        int cnt = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(copy_arr[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int[][] copy(){
        int[][] tmp = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                tmp[i][j] = arr[i][j];
            }
        }
        return tmp;
    }
}

class info{
    int x, y, idx;

    info(int x, int y, int idx){
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}