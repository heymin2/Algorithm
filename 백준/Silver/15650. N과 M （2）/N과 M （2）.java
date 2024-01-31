import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static StringBuffer sb = new StringBuffer();
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new int[M];

        re(0, 1);

        System.out.println(sb);
    }

    static void re(int cnt, int value) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(check[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = value; i <= N; i++) {
            check[cnt] = i;
            re(cnt + 1, i + 1);
        }
    }
}