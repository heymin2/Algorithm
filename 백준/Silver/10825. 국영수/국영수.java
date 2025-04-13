import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int K = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            list.add(new Node(name, K, E, M));
        }

        list.sort(null);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(list.get(i).name).append("\n");
        }
        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {
    String name;
    int K, E, M;

    public Node(String name, int K, int E, int M) {
        this.name = name;
        this.K = K;
        this.E = E;
        this.M = M;
    }

    public int compareTo(Node o) {
        if(this.K == o.K) {
            if(o.E == this.E) {
                if(this.M == o.M) {
                   return this.name.compareTo(o.name);
                }
                return o.M - this.M;
            }
            return this.E - o.E;
        }
        return o.K - this.K;
    }
}