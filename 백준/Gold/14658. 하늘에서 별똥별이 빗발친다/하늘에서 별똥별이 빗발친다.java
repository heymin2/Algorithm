import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L, K;
    static List<int[]> star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        star = new ArrayList<>();

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            star.add(new int[]{x, y});
        }
        
        int result = K;

        for(int[] s1: star) {
            for(int[] s2: star) {
                result = Math.min(result, boundStar(s1[0], s2[1]));
            }
        }

        System.out.println(result);
    }

    static int boundStar(int i, int j) {
        int cnt = K;

        for(int[] s : star) {
            if (i <= s[0] && s[0] <= i + L && j <= s[1] && s[1] <= j + L) cnt--;
        }

        return cnt;
    }
}