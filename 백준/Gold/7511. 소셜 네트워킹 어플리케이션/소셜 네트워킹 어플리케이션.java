import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st ;

        int t = Integer.parseInt(br.readLine());
        int test = 1;

        while(t-- > 0) {
            sb.append("Scenario ").append(test).append(":\n");
            int n = Integer.parseInt(br.readLine()); // 유저의 수
            int k = Integer.parseInt(br.readLine()); // 친구 관계
    
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }
            
            int m = Integer.parseInt(br.readLine()); /// 구할 쌍의 수
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(find(a) == find(b)) sb.append("1\n");
                else sb.append("0\n");
            }

            sb.append("\n");
            test++;
        }

        System.out.println(sb);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x > y) parent[y] = x;
        else parent[x] = y;
    }

    static int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
}