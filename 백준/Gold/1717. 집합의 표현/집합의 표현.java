import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
       
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) parent[i] = i;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int check = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(check == 0) {
                union(a, b);
            }
            else {
                if(find(a) == find(b)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
	}

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x <= y) parent[y] = x;
        else parent[y] = x;
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }
}