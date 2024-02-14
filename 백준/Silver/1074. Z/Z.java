import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int result = 0;

        while (N != 0) {
            N -= 1;

            int cnt = (int) Math.pow(2, N);

            if (R < cnt && C >= cnt) { // 2
                result += cnt * cnt;
                C -= cnt;
            } else if (R >= cnt && C < cnt) { // 3
                result += cnt * cnt * 2;
                R -= cnt;
            } else if (R >= cnt && C >= cnt) { // 4
                result += cnt * cnt * 3;
                C -= cnt;
                R -= cnt;
            }
        }
        System.out.println(result);
    }
}