import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        boolean[][][] check = new boolean[C+1][C+1][C+1];

        List<Integer> result = new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, C));

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(check[now.a][now.b][now.c]) continue;
            check[now.a][now.b][now.c] = true;

            if(now.a == 0) {
                result.add(now.c);
            }

            // A -> B
            if(now.a + now.b >= B) q.add(new Node(now.a-(B-now.b), B, now.c));
            else q.add(new Node(0, now.a + now.b, now.c));

            if(now.a + now.c >= C) q.add(new Node(now.a-(C-now.c), now.b, C));
            else q.add(new Node(0, now.b, now.a + now.c));

            // B
            if(now.b + now.a >= A) q.add(new Node(A, now.b-(A-now.a), now.c));
            else q.add(new Node(now.a + now.b, 0, now.c));

            if(now.b + now.c >= C) q.add(new Node(now.a, now.b-(C-now.c), C));
            else q.add(new Node(now.a, 0, now.c + now.b));

            // C
            if(now.c + now.a >= A) q.add(new Node(A, now.b, now.c-(A-now.a)));
            else q.add(new Node(now.a + now.c, now.b, 0));

            if(now.c + now.b >= B) q.add(new Node(now.a, B, now.c-(B-now.b)));
            else q.add(new Node(now.a, now.b + now.c, 0));
        }

        result.sort(null);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}

class Node {
    int a, b, c;

    public Node(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}