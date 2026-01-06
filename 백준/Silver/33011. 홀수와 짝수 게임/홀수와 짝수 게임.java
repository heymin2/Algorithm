import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int a = 0, b = 0;

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                if(Integer.parseInt(st.nextToken()) % 2 == 0) {
                    a++;
                }
                else {
                    b++;
                }
            }

            if(a - b == 0 || (a > b && a % 2 == 0) || (a < b && b % 2 == 0)) {
                sb.append("heeda0528").append("\n");
            }
            else {
                sb.append("amsminn").append("\n");
            }   
        }

        System.out.println(sb);
    }
}