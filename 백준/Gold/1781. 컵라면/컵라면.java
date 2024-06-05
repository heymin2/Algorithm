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
            int time = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            list.add(new Node(time, num));
        }

        Collections.sort(list);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            Node now = list.get(i);

            if(pq.size() < now.time) {
                pq.add(now.num);
            }
            else if(pq.size() == now.time) {
                if(pq.peek() < now.num) {
                    pq.poll();
                    pq.add(now.num);
                }
            }
        }

        int sum = 0;

        while (!pq.isEmpty()) {
           sum += pq.poll();
        }

        System.out.println(sum);
    }
}


class Node implements Comparable<Node>{
    int time;
    int num;

    public Node(int time, int num) {
        this.time = time;
        this.num = num;
    }

    @Override
    public int compareTo(Node o) {
        if(this.time == o.time) {
            return o.num - this.num;
        }
        return this.time - o.time;
    }
}