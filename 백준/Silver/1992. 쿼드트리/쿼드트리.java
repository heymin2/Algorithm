import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] arr;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        re(0, 0, N);
        System.out.println(sb);
    }

    static void re(int x, int y, int size) {
        if (check(x, y, size)) {
            sb.append(arr[x][y]);
            return;
        } else {
            sb.append("(");

            int newSize = size / 2;

            re(x, y, newSize);
            re(x, y + newSize, newSize);
            re(x + newSize, y, newSize);
            re(x + newSize, y + newSize, newSize);

            sb.append(")");
        }
    }

    static boolean check(int x, int y, int size) {
        int num = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (num != arr[i][j])
                    return false;
            }
        }
        return true;
    }
}