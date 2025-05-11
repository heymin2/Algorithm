import java.io.*;
import java.util.*;

public class Main {
    static List<Long> list = new ArrayList<>();
    static int[] digit = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dfs(0, 0);
        list.sort(null);


        if (N > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(N-1));
        }
    }

    public static void dfs(long num, int idx) {
        if(idx == 10) {
            if(!list.contains(num)) {
                list.add(num);
            }
            return;
        }

        dfs(num, idx+1);
        dfs(num * 10 + digit[idx], idx + 1);
    }
}