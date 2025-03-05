import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] inputs = new String[N];

            for(int i = 0; i < N; i++) {
                inputs[i] = br.readLine();
            }

            Arrays.sort(inputs);

            boolean check = true;
            for(int i = 1; i < N; i++) {
                if(inputs[i].startsWith(inputs[i-1])) {
                    check= false;
                    break;
                }
            }
            if(check) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}