import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[][];
    static int min = Integer.MAX_VALUE;
    static List<Node> list;
    static List<Node> list2;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1}; 
    static int max = 0;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        list = new ArrayList<>();
        list2 = new ArrayList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 2){
                    list.add(new Node(i, j));
                }

                if(arr[i][j] == 0){
                    list2.add(new Node(i, j));
                }
            }
        }
        wall(0, 0);
        System.out.println(max);
    }

    static void wall(int start, int cnt){
        if(cnt == 3){
            max = Math.max(bfs(), max);
            return;
        }

        for(int i = start; i < list2.size(); i++){
            Node now = list2.get(i);

            arr[now.x][now.y] = 1;
            wall(i+1, cnt+1);
            arr[now.x][now.y] = 0;
        }   
    }

    static int bfs(){
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][M];

        for(int i = 0; i < list.size(); i++){
            q.offer(list.get(i));
            visit[list.get(i).x][list.get(i).y] = true;
        }

        while(!q.isEmpty()){
            Node now = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny] || arr[nx][ny] == 1) continue;

                visit[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 0 && !visit[i][j]){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

class Node{
    int x, y;

    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}