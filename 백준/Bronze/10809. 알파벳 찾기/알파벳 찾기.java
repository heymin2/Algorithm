import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();

        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for(int i = 0; i < input.length(); i++) {
            int now = input.charAt(i) - 'a';
            if(arr[now] == -1) {
                arr[now] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}