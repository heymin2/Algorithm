import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] arr;
    static boolean[] alphabet;
    static int max = 1;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        alphabet = new boolean[26];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 0);
        System.out.println(max);
    }

    static void dfs(int x, int y, int cnt) {
        if (alphabet[arr[x][y] - 65]) {
            max = Math.max(max, cnt);
            return;
        }

        alphabet[arr[x][y] - 65] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C)
                continue;
            dfs(nx, ny, cnt + 1);
        }
        alphabet[arr[x][y] - 65] = false;
    }
}