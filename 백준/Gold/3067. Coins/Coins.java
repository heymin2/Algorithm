import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(; T > 0; T--) {
            int N = Integer.parseInt(br.readLine());
            int[] coin = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                coin[i] = Integer.parseInt(st.nextToken());
            }

            int money = Integer.parseInt(br.readLine());

            int[] result = new int[money+1];

            result[0] = 1;

            for(int i = 0; i < N; i++) {
                for(int j = coin[i]; j <= money; j++) {
                    result[j] = result[j] + result[j-coin[i]];
                }
            }

            sb.append(result[money]).append("\n");
        }

        System.out.println(sb);
    }
}