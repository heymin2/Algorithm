import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < H; i++) {
            String input = br.readLine();
            int cnt = -1;
            for(int j = 0; j < W; j++) {
                if(input.charAt(j) == 'c') cnt = 0;
                else {
                    if(cnt >= 0) cnt++;
                }
                sb.append(cnt).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}