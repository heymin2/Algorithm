import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int A = 0, B = 0;
        int len = input.length();

        if (input.endsWith("10")) {
            B = 10;
            A = Integer.parseInt(input.substring(0, len - 2));
        } else {
            B = Integer.parseInt(input.substring(len - 1));
            A = Integer.parseInt(input.substring(0, len - 1));
        }

        System.out.println(A + B);
    }
}