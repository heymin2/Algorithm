import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] check = new int[26];

        for (int i = 0; i < input.length(); i++) {
            check[input.charAt(i) - 'A']++;
        }

        StringBuilder sb = new StringBuilder();
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (check[i] % 2 == 1) {
                if (mid == 0) {
                    mid = (char)(i + 'A');
                } else {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < check[i] / 2; j++) {
                sb.append((char)(i + 'A'));
            }
        }

        String result = sb.toString();
        String reversed = new StringBuilder(result).reverse().toString();

        if (mid != 0) {
            result = result + mid + reversed;
        } else {
            result = result + reversed;
        }

        System.out.println(result);
    }
}
