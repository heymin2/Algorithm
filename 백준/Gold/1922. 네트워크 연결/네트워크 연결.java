import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node>[] list = new ArrayList[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new Node(B, C));
            list[B].add(new Node(A, C));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[N+1];
        int cnt = 0;

        pq.offer(new Node(N, cnt));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if(visit[now.v]) continue;
            
            visit[now.v] = true;
            cnt += now.cost;

            for(int i = 0; i < list[now.v].size(); i++) {
                Node next = list[now.v].get(i);
                pq.offer(new Node(next.v, next.cost));
            }
        }

        System.out.println(cnt);
    }
}

class Node implements Comparable<Node>{
    int v, cost;

    public Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}