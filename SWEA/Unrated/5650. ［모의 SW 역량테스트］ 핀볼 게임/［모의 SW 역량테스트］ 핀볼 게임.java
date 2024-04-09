import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution
{
	static int N, arr[][], max;
    static List<ball> list;
    static List<ball>[] worm;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine().trim());
            arr = new int[N][N];

            list = new ArrayList<>();
            worm = new ArrayList[5];

            for (int i = 0; i < 5; i++) {
                worm[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine().trim());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    if (arr[i][j] == 0) { // 핀볼이 위치할 수 있는 곳
                        list.add(new ball(i, j));
                    } else if (arr[i][j] >= 6) {
                        worm[arr[i][j] - 6].add(new ball(i, j));
                    }
                }
            }

            max = 0;
            sb.append("#").append(test).append(" ").append(game()).append("\n");
        }
        System.out.println(sb);
    }

    static int game() {
        for (ball b : list) {
            for (int i = 0; i < 4; i++) {
                max = Math.max(checkSum(b.x, b.y, i), max);
            }
        }

        return max;
    }

    static int checkSum(int x, int y, int d) {
        int sum = 0;
        int nx = x, ny = y;

        while (true) {
            nx += dx[d];
            ny += dy[d];

            if (nx == -1 || ny == -1 || nx == N || ny == N || arr[nx][ny] == 5) { // 벽인 경우, 사각형인 경우
                sum++;
                d = wall(d); // 방향 바꾸기
            } else if (1 <= arr[nx][ny] && arr[nx][ny] <= 4) { // 삼각형 블록
                sum++;
                d = square(arr[nx][ny], d);
            } else if (6 <= arr[nx][ny] && arr[nx][ny] <= 10) { // 웜홀 통과
                for (ball w : worm[arr[nx][ny] - 6]) {
                    if (nx != w.x || ny != w.y) {
                        nx = w.x;
                        ny = w.y;
                        break;
                    }
                }
            } else if ((nx == x && ny == y) || (arr[nx][ny] == -1)) { // 출발 위치 or 블랙홀
                break;
            }
        }

        return sum;

    }

    static int wall(int d) {
        switch (d) {
            case 0:
                return 1;
            case 1:
                return 0;
            case 2:
                return 3;
            case 3:
                return 2;
        }
        return 0;
    }

    static int square(int num, int d) {
        switch (num) {
            case 1:
                switch (d) {
                    case 0:
                        return 2;
                    case 1:
                        return 0;
                    case 2:
                        return 3;
                    case 3:
                        return 1;
                }
            case 2:
                switch (d) {
                    case 0:
                        return 1;
                    case 1:
                        return 2;
                    case 2:
                        return 3;
                    case 3:
                        return 0;
                }
            case 3:
                switch (d) {
                    case 0:
                        return 1;
                    case 1:
                        return 3;
                    case 2:
                        return 0;
                    case 3:
                        return 2;
                }
            case 4:
                switch (d) {
                    case 0:
                        return 3;
                    case 1:
                        return 0;
                    case 2:
                        return 1;
                    case 3:
                        return 2;
                }
        }
        return 0;
    }
}

class ball {
    int x, y, num;

    ball(int x, int y) {
        this.x = x;
        this.y = y;
    }
}