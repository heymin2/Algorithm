import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String input = br.readLine();

            if(input.length() >= M) {
                map.put(input, map.getOrDefault(input, 0) + 1);
            }
        }
        
        List<String> words = new ArrayList<>(map.keySet());
        words.sort((a, b) -> {
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }
            if (a.length() != b.length()) {
                return b.length() - a.length();
            }
            return a.compareTo(b);
        });

        StringBuffer sb = new StringBuffer();
        for(String word : words) {
            sb.append(word).append("\n");
        }

        System.out.println(sb);
	}
}