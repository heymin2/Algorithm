import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int cnt = 0;
        
        for(int i = 0; i < A.length() - B.length() + 1; i++) {
            boolean flag = true;

            for(int j = 0; j < B.length(); j++) {
                if(B.charAt(j) != A.charAt(i+j)) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                cnt++;
                i += B.length() - 1;
            }
        }        

        System.out.println(cnt);
    }
}