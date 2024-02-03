import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int now = 0;
        int BCD = 0;
        int binSize = 1;
        int nowTemp = 0;
        int cnt = 0;
        int idx = 1;

        while (cnt != 5) {
            nowTemp = now;
            while (now / Math.pow(2, binSize) >= 1) {
                binSize++;
            }
            int[] bin = new int[binSize];

            for (int i = binSize - 1; i >= 0; i--) {
                bin[i] = nowTemp%2;
                nowTemp /= 2;
            }

            for (int i = 0; i < binSize; i++) {
                if ((n == k && idx % n == 0) || (n != k && idx % n == k)) {
                    sb.append(bin[i]).append(" ");
                    cnt++;
                    if (cnt == 5) break;
                }
                idx++;
            }
            now++;
        }
        System.out.println(sb);
    }
}