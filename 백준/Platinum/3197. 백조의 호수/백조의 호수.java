import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] arr;
    static List<int[]> list;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static Queue<int[]> swan_q = new ArrayDeque<>(); // 백조
    static boolean[][] swan_visit;
    static Queue<int[]> melt_q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        swan_visit = new boolean[R][C];
        list = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);

                if (arr[i][j] == 'L') {
                    list.add(new int[] { i, j });
                }

                if (arr[i][j] != 'X') {
                    melt_q.offer(new int[] { i, j });
                }
            }
        }

        swan_q.offer(new int[]{list.get(0)[0], list.get(0)[1]});
        swan_visit[list.get(0)[0]][list.get(0)[1]] = true;

        int cnt = 0;

        while (!meet()) {
            melt();
            cnt++;
        }

        System.out.println(cnt);

    }

    static void melt() {
        int size = melt_q.size();

        for(int i = 0; i < size; i++){
            int[] now = melt_q.poll();

            for(int k = 0; k < 4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C)
                    continue;
                if(arr[nx][ny] == 'X'){
                    arr[nx][ny] = '.';
                    melt_q.offer(new int[]{nx,ny});
                }
            }
        }
    }

    static boolean meet() { // 사람 만나는지 체크
        Queue<int[]> q = new ArrayDeque<>();

        while (!swan_q.isEmpty()) {
            int[] now = swan_q.poll();

            if (now[0] == list.get(1)[0] && now[1] == list.get(1)[1]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= R || ny >= C || swan_visit[nx][ny])
                    continue;

                swan_visit[nx][ny] = true;

                if(arr[nx][ny] == 'X'){
                    q.offer(new int[] { nx, ny });
                }
                else{
                    swan_q.offer(new int[] { nx, ny });
                }
            }
        }
        swan_q = q;
        return false;
    }
}