import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 도시 수
        M = Integer.parseInt(br.readLine()); // 경로 수

        parent = new int[N+1]; // 초기값 생성
        for(int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                int value = Integer.parseInt(st.nextToken());
                if(value == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int n = find(Integer.parseInt(st.nextToken()));

        for(int i = 1; i < M; i++) {
            if(n != find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }
        
        System.out.println("YES");
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if(x > y) parent[y] = x;
    }

    static int find(int x) {
        if(x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}