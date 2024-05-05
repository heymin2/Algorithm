import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, x, y, K, arr[][], dice[];
    static int[] dx = {0, 0, -1, 1}; // 동서북남
    static int[] dy = {1, -1, 0, 0};

     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); 
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 명령 개수

        arr = new int[N][M];
        dice = new int[6];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            int now = Integer.parseInt(st.nextToken()) -1;

            x += dx[now];
            y += dy[now];

            if(x < 0 || y < 0 || x >= N || y >= M) { // 명령 무시
                x -= dx[now];
                y -= dy[now];
                continue;
            }

            if(now == 0) { // 동
                right();
            }
            else if(now == 1) { // 서
                left();
            }
            else if(now == 2) { // 북
                up();
            }
            else if(now == 3) { // 남
                down();
            }
            
            if(arr[x][y] == 0) { // 주사위 -> 칸 복사
                arr[x][y] = dice[1];
            }
            else{ // 칸 -> 주사위 복사
                dice[1] = arr[x][y];
                arr[x][y] = 0;
            }
            sb.append(dice[0]).append("\n");
        }
        System.out.println(sb);        
    }

    static void right() {
        int temp = dice[0];
		dice[0] = dice[4];
		dice[4] = dice[1];
		dice[1] = dice[5];
		dice[5] = temp;
    } 

    static void left() {
        int temp = dice[0];
		dice[0] = dice[5];
		dice[5] = dice[1];
		dice[1] = dice[4];
		dice[4] = temp;
    }

    static void up() {
        int temp = dice[0];
		dice[0] = dice[2];
		dice[2] = dice[1];
		dice[1] = dice[3];
		dice[3] = temp;
    }

    static void down() {
        int temp = dice[0];
		dice[0] = dice[3];
		dice[3] = dice[1];
		dice[1] = dice[2];
		dice[2] = temp;
    }
}