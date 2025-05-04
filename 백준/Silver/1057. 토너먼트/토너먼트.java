import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int JIMIN = Integer.parseInt(st.nextToken());
        int HANSU = Integer.parseInt(st.nextToken());

        int result = 0;
        while(JIMIN != HANSU) {
            JIMIN = JIMIN/2 + JIMIN%2;
            HANSU = HANSU/2 + HANSU%2;
            result++;
        }
        
        System.out.println(result);
    }
}