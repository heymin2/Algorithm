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
    static boolean[][] visit;
    static List<block> list;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int total = 0;

        while (true) {
            int t = (int) Math.pow(findGroup(), 2);

            if (t == 0) {
                break;
            }

            total += t;

            gravity();
            antiClock90();
            gravity();
        }

        System.out.println(total);
    }

    static int findGroup() { // 블록그룹 찾기
        visit = new boolean[N][N];
        int maxBlock = 0;
        int maxColor = 0;
        int x = 0, y = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j] && arr[i][j] > 0) {
                    list = new ArrayList<>();
                    int[] result = findBlock(i, j);

                    if (maxBlock < result[0]) {
                        maxBlock = result[0];
                        maxColor = result[1];
                        x = i;
                        y = j;
                    } else if (maxBlock == result[0]) {
                        if (maxColor < result[1]) {
                            maxColor = result[1];
                            x = i;
                            y = j;
                        } else if (maxColor == result[1]) {
                            if (x < i) {
                                x = i;
                                y = j;
                            } else if (x == i) {
                                y = j;
                            }
                        }
                    }

                    for (block b : list) {
                        visit[b.x][b.y] = false;
                    }
                }
            }
        }

        if (maxBlock >= 2) {
            return removeBlock(x, y);
        }
        return 0;
    }

    static int[] findBlock(int x, int y) { // 블록그룹 개수, 무지개 개수 찾기
        Queue<block> q = new ArrayDeque<>();
        int[] result = new int[2];

        q.offer(new block(x, y, 1));
        visit[x][y] = true;
        int color = arr[x][y];

        while (!q.isEmpty()) {
            block now = q.poll();
            result[0]++;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny])
                    continue;

                if (arr[nx][ny] == color) {
                    visit[nx][ny] = true;
                    q.offer(new block(nx, ny, now.cnt + 1));
                }

                if (arr[nx][ny] == 0) {
                    result[1]++;
                    visit[nx][ny] = true; // 문제 - 다음번에 체크할때는 true라서 사용 못하게 된다! color가 0인 경우에 visit 방문 풀어주는 거 추가해야함!
                    q.offer(new block(nx, ny, now.cnt + 1));
                    list.add(new block(nx, ny, 0));
                }
            }
        }

        return result;
    }

    static int removeBlock(int x, int y) { // 제거한 블럭은 -2로 설정, 제거한 수 리턴
        Queue<block> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[N][N];

        q.offer(new block(x, y, 1));
        visit[x][y] = true;
        int color = arr[x][y];
        int result = 0;

        while (!q.isEmpty()) {
            block now = q.poll();
            arr[now.x][now.y] = -2;
            result++;

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny])
                    continue;

                if (arr[nx][ny] == 0 || arr[nx][ny] == color) {
                    visit[nx][ny] = true;
                    q.offer(new block(nx, ny, now.cnt + 1));
                }
            }
        }

        return result;
    }

    static void gravity() { // 중력 작용, -1의 위까지, 가장 아래까지 이동
        for (int i = 0; i < N; i++) {
            int bottom = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (arr[j][i] == -1) {
                    bottom = j - 1;
                } else if (arr[j][i] != -2) {
                    if (bottom != j) {
                        arr[bottom][i] = arr[j][i];
                        arr[j][i] = -2;
                    }
                    bottom--;
                }
            }
        }
    }

    static void antiClock90() { // 90도 반시계
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            int v = N - 1;
            for (int j = 0; j < N; j++) {
                temp[v][i] = arr[i][j];
                v--;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }

}

class block {
    int x, y, cnt;

    block(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}