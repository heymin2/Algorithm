import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();

        while(N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int now = Integer.parseInt(st.nextToken());

            if(now == 1) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }
            else if(now == 2) {
                if(list.isEmpty()) sb.append("-1\n");
                else {
                    sb.append(list.remove(list.size()-1)).append("\n");
                }
            }
            else if(now == 3) {
                sb.append(list.size()).append("\n");
            }
            else if(now == 4) {
                sb.append(list.isEmpty() ? "1\n" : "0\n");
            }
            else if(now == 5) {
                if(list.isEmpty()) sb.append("-1\n");
                else {
                    sb.append(list.get(list.size()-1)).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}