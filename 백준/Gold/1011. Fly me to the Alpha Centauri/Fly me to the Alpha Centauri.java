import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            long distance = y - x; // 이동해야 할 거리
            long max = (long) Math.sqrt(distance); // 최대 이동 거리

            if (max * max == distance) {
                sb.append(2 * max - 1).append("\n");
            } else if (max * max < distance && distance <= max * max + max) {
                sb.append(2 * max).append("\n");
            } else {
                sb.append(2 * max + 1).append("\n");
            }
        }

        System.out.println(sb);
    }
}