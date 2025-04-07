import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String X = st.nextToken();
        String Y = st.nextToken();

        int result = X.length();

        for(int i = 0; i < Y.length() - X.length() + 1; i++) {
            int tmp = 0;
            for(int j = 0; j < X.length(); j++) {
                if(X.charAt(j) != Y.charAt(j + i)) {
                    tmp++;
                }
            }
            if(result > tmp) result = tmp;
        }

        System.out.println(result);
    }
}