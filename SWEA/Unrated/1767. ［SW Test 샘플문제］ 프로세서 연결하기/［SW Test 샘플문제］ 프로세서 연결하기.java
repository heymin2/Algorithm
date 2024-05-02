import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution
{
	static int N, max, min, arr[][];
    static List<int[]> list;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

     public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            list = new ArrayList<>();

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    if(arr[i][j] == 1) {
                        if(i == 0 || j == 0 || i == N-1 || j == N-1) continue;
                        list.add(new int[]{i,j});
                    }
                }
            }

            max = 0; 
            min = Integer.MAX_VALUE;

            subs(0, 0, 0);
            sb.append("#").append(test).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }

    static void subs(int cnt, int core, int len) {
        if(max > core + (list.size()-cnt)) return;
        if(cnt == list.size()) {
            if(max < core){
                max = core;
                min = len;
            } else if(max == core){
                min = Math.min(min, len);
            }
            return;
        }

        int[] now = list.get(cnt);

        for(int d = 0; d < 4; d++) {
            int count = 0;
            int nx = now[0];
            int ny = now[1];

            while(true) { 
                nx += dx[d];
                ny += dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
                if(arr[nx][ny] == 1) {
                    count = 0;
                    break;
                }
                count++;
            }

            if(count != 0) {
                // 방문처리
                nx = now[0];
                ny = now[1];

                for(int c = 0; c < count; c++) { 
                    nx += dx[d];
                    ny += dy[d];
                    arr[nx][ny] = 1;
                }

                subs(cnt+1, core+1, len+count);
                // 복원처리
                nx = now[0]; 
                ny = now[1];

                for(int c = 0; c < count; c++) { 
                    nx += dx[d];
                    ny += dy[d];
                    arr[nx][ny] = 0;
                }
            }
        }
        subs(cnt+1, core, len);
    }
}