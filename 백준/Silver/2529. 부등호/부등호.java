import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[] visit;
    static char[] arr;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new char[N];
        visit = new boolean[10];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        dfs("", 0);

        StringBuilder sb = new StringBuilder();
        sb.append(result.get(result.size()-1)).append("\n").append(result.get(0));
        System.out.println(sb);
    }

    static void dfs(String num, int idx) {
        if(idx == N + 1) {
            result.add(num);
            return;
        }

        for(int i = 0; i <= 9; i++) {
            if(visit[i]) continue;
            if(idx == 0 || arrCheck(num.charAt(idx - 1) - '0', i, arr[idx -1])) {
                visit[i] = true;
                dfs(num + i, idx + 1);
                visit[i] = false;
            }
        }
    }

    static boolean arrCheck(int a, int b, char c) {
        if(c == '<') {
            if(a > b) return false;
        } 
        else if(c == '>') {
            if(a < b) return false;
        }
        return true;
    }
}