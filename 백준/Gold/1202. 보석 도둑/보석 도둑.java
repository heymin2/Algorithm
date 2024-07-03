import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        int[] bag = new int[K];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.add(new Node(m, v));
        }

        for(int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Collections.sort(list);
        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long result = 0;
        int j = 0;

        for(int i = 0; i < K; i++) {
            while(j < N && list.get(j).m <= bag[i]) {
                pq.offer(list.get(j++).v);
            }

            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        
        System.out.println(result);
    }
}

class Node implements Comparable<Node>{
    int m;
    int v;

    public Node(int m, int v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(Node o) {
        return m - o.m;
    }
}