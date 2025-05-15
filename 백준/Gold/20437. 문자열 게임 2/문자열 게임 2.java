import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i < 26; i++) {
                list.add(new ArrayList<>());
            }

            for(int i = 0; i < W.length(); i++) {
                list.get(W.charAt(i) - '0' - 49).add(i);
            }

            int min = Integer.MAX_VALUE;
            int max = 0;

            for(int i = 0; i < 26; i++) {
                if(list.get(i).size() >= K) {
                    for(int j = K; j <= list.get(i).size(); j++) {
                        int now = list.get(i).get(j-1) - list.get(i).get(j-K);

                        min = Math.min(min, now);
                        max = Math.max(max, now);
                    }
                }
            }

            if(min == Integer.MAX_VALUE) {
                sb.append(-1).append("\n");
            }
            else {
                sb.append(min+1).append(" ").append(max+1).append("\n");
            }
        }

        System.out.println(sb);
    }
}