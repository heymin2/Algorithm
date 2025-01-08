import java.util.*;
import java.io.*;

public class Main {
    static int min = 9999;
    static int[][][] HP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.add(0);
        list.add(0);

        HP = new int[list.get(0)+1][list.get(1)+1][list.get(2)+1];

        dfs(list.get(0), list.get(1), list.get(2), 0);

        System.out.println(min);
    }

    static void dfs(int a, int b, int c, int num) {
        if(a <= 0 && b <= 0 && c <= 0) {
            min = Math.min(min, num);
            return;
        }

        if(a < 0) a = 0;
        if(b < 0) b = 0;
        if(c < 0) c = 0;

        if(HP[a][b][c] <= num && HP[a][b][c] != 0) return;

        HP[a][b][c] = num;

        dfs(a-9, b-3, c-1, num+1);
        dfs(a-9, b-1, c-3, num+1);
        dfs(a-3, b-9, c-1, num+1);
        dfs(a-3, b-1, c-9, num+1);
        dfs(a-1, b-9, c-3, num+1);
        dfs(a-1, b-3, c-9, num+1);
    }
}