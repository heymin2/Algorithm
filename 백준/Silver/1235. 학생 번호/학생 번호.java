import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        HashSet<String> set = new HashSet<>();
        for(int i = 1; i <= arr[0].length(); i++) {
            for(int j = 0; j < N; j++) {
                set.add(arr[j].substring(arr[j].length()-i));
            }

            if(set.size() == N) {
                System.out.println(i);
                break;
            }

            set.clear();
        }
    }
}