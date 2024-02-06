import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][8];

        for (int i = 1; i <= 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            check = new int[5];
            check[idx] = v;

            left(idx, v);
            right(idx, v);

            for (int j = 1; j <= 4; j++) {
                if (check[j] == 1) {
                    clock(j);
                } else if (check[j] == -1) {
                    anticlock(j);
                }
            }
        }

        int sum = 0;
        int n = 1;

        for (int i = 1; i <= 4; i++) {
            sum += arr[i][0] * n;
            n *= 2;
        }

        System.out.println(sum);
    }

    static void left(int idx, int v) {
        if (idx > 1 && arr[idx][6] != arr[idx - 1][2]) {
            check[idx - 1] = v * -1;
            left(idx - 1, v * -1);
        }
    }

    static void right(int idx, int v) {
        if (idx < 4 && arr[idx][2] != arr[idx + 1][6]) {
            check[idx + 1] = v * -1;
            right(idx + 1, v * -1);
        }
    }

    static void anticlock(int idx) {
        int tmp = arr[idx][0];
        for (int i = 1; i < 8; i++) {
            arr[idx][i - 1] = arr[idx][i];
        }
        arr[idx][7] = tmp;
    }

    static void clock(int idx) {
        int tmp = arr[idx][7];
        for (int i = 7; i > 0; i--) {
            arr[idx][i] = arr[idx][i - 1];
        }
        arr[idx][0] = tmp;
    }
}