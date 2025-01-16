import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
        String s = Integer.toBinaryString(X);

        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') result++;
        }

        System.out.println(result);
    }
}