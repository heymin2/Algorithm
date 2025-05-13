import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> list = new HashSet<>();
        for(int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            if(list.contains(input)) {
                result.add(input);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");

        result.sort(null);

        for(int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}