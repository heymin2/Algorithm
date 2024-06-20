import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Node(d, w));
        }
        
        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(list.get(0).w);

        for(int i = 1; i < N; i++) {
            Node cnt = list.get(i);

            if(cnt.d > pq.size()) {
                pq.add(cnt.w);
            }
            else {
                if(pq.peek() < cnt.w) {
                    pq.poll();
                    pq.add(cnt.w);
                }
            }
        }

        int sum = 0;

        while(!pq.isEmpty()) {
            sum += pq.poll();
        }

        System.out.println(sum);
    }
}

class Node implements Comparable<Node>{
    int d, w;

    public Node(int d, int w) {
        this.w = w;
        this.d = d;
    }

    @Override
    public int compareTo(Node o) {
        if (d == o.d) {
            return w - o.w;
        }
        return d - o.d;
    }
}