import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][], min;
    static boolean[][] visit;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j] && arr[i][j] != 0){
                    check(i, j, num);
                    num++;
                }
            }
        }

        min = Integer.MAX_VALUE;
        for(int i = 1; i < num; i++) {
            bridge(i);
        }

        System.out.println(min);
    }

    static void check(int x, int y, int num) { // 섬 체크
        Queue<Node> q = new ArrayDeque<>();

        visit[x][y] = true;
        arr[x][y] = num;
        q.offer(new Node(x, y));

        while(!q.isEmpty()) {
            Node now = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit[nx][ny] || arr[nx][ny] == 0) continue;

                visit[nx][ny] = true;
                arr[nx][ny] = num;
                q.offer(new Node(nx, ny));
            }
        }
    }

    static void bridge(int num) {
        boolean[][] visit2 = new boolean[N][N];
        Queue<Node> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j] == num) {
                    q.add(new Node(i, j, 0));
                    visit2[i][j] = true; 
                }
            }
        }

        while(!q.isEmpty()) {
            Node now = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(visit2[nx][ny]) continue;

                if(arr[nx][ny] != num && arr[nx][ny] != 0){
                    min = Math.min(min, now.time);
                }

                if(arr[nx][ny] == 0){
                    visit2[nx][ny] = true;
                    q.offer(new Node(nx, ny, now.time+1));
                }
            }
        }
    }
}

class Node {
    int x, y, time;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}