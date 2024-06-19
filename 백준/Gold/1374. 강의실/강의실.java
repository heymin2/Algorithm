import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
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

            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Node(num, start, end));
        }

        Collections.sort(list);

        PriorityQueue<Integer> room = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            if(room.isEmpty()) {
                room.offer(list.get(i).end);
            }
            else {
                if(room.peek() > list.get(i).start) {
                    room.offer(list.get(i).end);
                }
                else {
                    room.poll();
                    room.offer(list.get(i).end);
                }
            }
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