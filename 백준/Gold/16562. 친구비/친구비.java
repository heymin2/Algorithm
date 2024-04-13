import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, cost[], parent[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        cost = new int[N+1];
        parent = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }

        boolean[] visit = new boolean[N+1];
        int result = 0;

        for(int i = 1; i <= N; i++) {
            int idx = find(i);

            if(!visit[idx]){
                visit[idx] = true;
                result += cost[idx];
            }
        }

        if(result > K){
            System.out.println("Oh no");
        }
        else{
            System.out.println(result);
        }
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if(x == y) return;

        if(cost[x] >= cost[y]) parent[x] = y;
        else parent[y] = x;
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return find(parent[x]);
    }
}