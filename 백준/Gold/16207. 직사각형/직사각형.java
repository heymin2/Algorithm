import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        TreeMap<Integer, Integer> countMap = new TreeMap<>(Collections.reverseOrder());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int length = Integer.parseInt(st.nextToken());
            countMap.put(length, countMap.getOrDefault(length, 0) + 1);
        }

        List<Integer> keys = new ArrayList<>(countMap.keySet());
        List<Integer> sides = new ArrayList<>();

        for (int key : keys) {
            int cnt = countMap.get(key);
            
            while (cnt >= 2) {
                sides.add(key);
                cnt -= 2;
            }

            if (cnt == 1 && key > 2) {
                countMap.put(key - 1, countMap.getOrDefault(key - 1, 0) + 1);
            }
        }

        long maxArea = 0;
        for (int i = 0; i + 1 < sides.size(); i += 2) {
            maxArea += (long) sides.get(i) * sides.get(i + 1);
        }

        System.out.println(maxArea);
    }
}
