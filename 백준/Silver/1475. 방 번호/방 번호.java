import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int[] arr = new int[10];

        for(int i = 0; i < N.length(); i++) {
            int v = N.charAt(i) - '0';

            if(v == 9) {
                v = 6;
            }
            arr[v]++;
        }

        if(arr[6] % 2 == 0) {
            arr[6] /= 2;
        }
        else {
            arr[6] = arr[6] / 2 + 1;
        }

        Arrays.sort(arr);
        System.out.println(arr[9]);
    }
}