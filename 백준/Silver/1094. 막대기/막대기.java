import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int X = Integer.parseInt(br.readLine());
       int result = 0;

        while(true) {
            if(X == 64 || X == 32 || X == 16 || X == 8 || X == 4 || X == 2 || X == 1) {
                System.out.println(result+1);
                break;
            }
            else {
                if(32 < X && X < 64) {
                    X -= 32;
                }
                else if(16 < X && X < 32) {
                    X -= 16;
                }
                else if(8 < X && X < 16) {
                    X -= 8;
                }
                else if(4 < X && X < 8) {
                    X -= 4;
                }
                else if(2 < X && X < 4) {
                    X -= 2;
                }
                result++;
            }
        }
    }
}