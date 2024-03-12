import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<road>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        visit = new boolean[N+1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new road(b, c));
            list[b].add(new road(a, c));
        }

        System.out.println(prim());
    }

    static int prim(){
        PriorityQueue<road> pq = new PriorityQueue<>();
        pq.offer(new road(1, 0));
        int dist = 0, max = 0;

        while(!pq.isEmpty()){
            road now = pq.poll();

            if(visit[now.y]) continue;

            visit[now.y] = true;
            max = Math.max(max, now.cost);
            dist += now.cost;

            for(int i = 0; i < list[now.y].size(); i++){
                road next = list[now.y].get(i);
                if(!visit[next.y]){
                    pq.offer(new road(next.y, next.cost));
                }
            }
        }
        return dist - max;
    }
}

class road implements Comparable<road>{
    int y, cost;

    road(int y, int cost){
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(road o) {
        return this.cost - o.cost;
    }
}