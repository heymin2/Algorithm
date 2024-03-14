import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    static int V, E;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
        }

        System.out.println(treeMin());
    }
    
    static int treeMin() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[V + 1];
        int cnt = 0;

        pq.offer(new Node(V, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visit[now.v]) continue;

            visit[now.v] = true;
            cnt += now.cost;

            for (int i = 0; i < list[now.v].size(); i++) {
                Node next = list[now.v].get(i);

                if (visit[next.v]) continue;

                pq.offer(new Node(next.v, next.cost));
            }
        }
        return cnt;
    }
}

class Node implements Comparable<Node> {
    int v, cost;

    Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}