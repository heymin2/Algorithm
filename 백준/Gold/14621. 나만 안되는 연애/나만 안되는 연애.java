import java.util.*;
import java.io.*;

public class Main {
    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] arr = new char[N+1];
        parent = new int[N+1];

        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Node[] road = new Node[M];

        for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
            
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			road[i] = new Node(u, v, d);
		}

        Arrays.sort(road);

        int cnt = 0;
        int result = 0;

        for(int i = 0; i < M; i++) {
            if(arr[road[i].u] == (arr[road[i].v]) || find(road[i].u) == find(road[i].v)) continue; 

            result += road[i].d;
            union(road[i].u, road[i].v);
            cnt++;
        }

        if(cnt != N-1) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
    }

    static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		x = parent[x];
		y = parent[y];
		
		if (x < y) parent[y] = x;
		else parent[x] = y;
	}
}

class Node implements Comparable<Node>{
    int u, v, d;

    public Node(int u, int v, int d) {
        this.u = u;
        this.v = v;
        this.d = d;
    }

    @Override
    public int compareTo(Node o) {
        return this.d - o.d;
    }
}