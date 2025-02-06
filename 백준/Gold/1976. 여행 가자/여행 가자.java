import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시의 수
        int M = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시의 수

        parent = new int[N+1];

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++) {
                int check = Integer.parseInt(st.nextToken());
                if(check == 1) {
                    union(i, j);
                }
            }
        }
        
        st = new StringTokenizer(br.readLine());
        int n = find(Integer.parseInt(st.nextToken()));
        boolean flag = true;
        for(int i = 1; i < M; i++) {
            if(n != find(Integer.parseInt(st.nextToken()))) {
                flag = false;
                System.out.println("NO");
                break;
            }
        }

        if(flag) System.out.println("YES");
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x > y) parent[y] = x;
        else parent[x] = y;
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }
        else return parent[x] = find(parent[x]);
    }
}