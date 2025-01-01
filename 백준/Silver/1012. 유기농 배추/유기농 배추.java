import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-- != 0) {
            int cnt = 0;

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            boolean[][] arr = new boolean[N][M];
            boolean[][] check = new boolean[N][M];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x][y] = true;
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] && !check[i][j]) {
                        cnt++;

                        Queue<int[]> q = new ArrayDeque<>();
                        
                        check[i][j] = true;
                        q.add(new int[]{i,j});

                        while(!q.isEmpty()) {
                            int[] now = q.poll();

                            for(int k = 0; k < 4; k++) {
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];

                                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                                if(!arr[nx][ny] || check[nx][ny]) continue;

                                q.add(new int[]{nx, ny});
                                check[nx][ny] = true;
                            }
                        }
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}