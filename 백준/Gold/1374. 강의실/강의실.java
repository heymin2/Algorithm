import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Node(num, start, end));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(pq.poll().end);

        while(!pq.isEmpty()) {
            int size = room.size();
            Node cnt = pq.poll();
            boolean flag = false;

            for(int i = 0; i < size; i++) {
                if(room.peek() <= cnt.start) {
                    room.poll();
                    room.add(cnt.end);
                    flag = true;
                    break;
                }
            }
            if(!flag) room.add(cnt.end);
        }
        
        System.out.println(room.size());
    }
}

class Node implements Comparable<Node>{
    int num, start, end;

    public Node(int num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Node o) {
        return start - o.start;
    }
}