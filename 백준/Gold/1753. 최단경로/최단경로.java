import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int V,E,K;
    static List<Node>[] list;
    static int[] cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[V+1];

        for(int i = 1; i <= V; i++){
            list[i] = new ArrayList<>();
        }

        K = Integer.parseInt(br.readLine());

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list[A].add(new Node(B, C));
        }

        min();

        for(int i = 1; i <= V; i++){
            if(cnt[i] == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }
            else{
                sb.append(cnt[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void min(){
        boolean[] visit = new boolean[V+1];
        cnt  = new int[V+1];

        Arrays.fill(cnt, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(K, 0));
        cnt[K] = 0;

        while(!pq.isEmpty()){
            Node now = pq.poll();

            if(visit[now.v]) continue;

            visit[now.v] = true;

            for(int i = 0; i < list[now.v].size(); i++){
                Node next = list[now.v].get(i);

                if(cnt[next.v] < next.cnt + now.cnt) continue;
                cnt[next.v] = next.cnt + now.cnt;
                pq.offer(new Node(next.v, next.cnt + now.cnt));
            }
        }
    }
}

class Node implements Comparable<Node>{
    int v, cnt;

    Node(int v, int cnt){
        this.v = v;
        this.cnt = cnt;
    }
    
    @Override
    public int compareTo(Node o) {
        return this.cnt - o.cnt;
    }
}