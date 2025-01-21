import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String result = "YES";

        for(int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);

            if(now == 'p') {
                if(i+1 < input.length() && input.charAt(i+1) == 'i') {
                    i++;
                }
                else result = "NO";
            }
            else if(now == 'k') {
                if(i+1 < input.length() && input.charAt(i+1) == 'a'){
                    i++;
                }
                else result = "NO";
            }
            else if(now == 'c') {
                if(i+2 < input.length() && input.charAt(i+1) == 'h' && input.charAt(i+2) == 'u'){
                    i += 2;
                }
                else result = "NO";
            }
            else {
                result = "NO";
            }
        }

        System.out.println(result);
    }
}