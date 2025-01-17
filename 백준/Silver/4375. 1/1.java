import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int n, remainder, count;

        while(true) {
            if((input = br.readLine()) == null) break;
            n = Integer.parseInt(input);
            remainder = 1;
            count = 1;
            
            while (remainder % n != 0){
                remainder = (remainder * 10 + 1) % n;
                count++;
            }

            System.out.println(count);
        }
    }
}