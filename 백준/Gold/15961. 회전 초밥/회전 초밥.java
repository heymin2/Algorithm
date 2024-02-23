import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 벨트에 놓인 접시의 수
        d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
        c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = k - 1;

        for (int i = left; i <= right; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        map.put(c, map.getOrDefault(c, 0) + 1); // 쿠폰 번호 - 초밥
        max = map.size();

        while (left != N) {
            map.put(arr[left], map.getOrDefault(arr[left], 0) - 1);

            if (map.get(arr[left]) == 0) {
                map.remove(arr[left]);
            }

            left++;
            right++;

            if (right == N) {
                right = 0;
            }

            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);
            max = Math.max(max, map.size());
        }
        System.out.println(max);
    }
}