import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(1, A));

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.value == B) {
                System.out.println(now.cnt);
                return;
            }

            if(now.value > B) continue;

            q.add(new Node(now.cnt+1, now.value * 2));
            q.add(new Node(now.cnt+1, now.value*10 + 1));
        }
        
        System.out.println(-1);
    }
}

class Node {
    int cnt;
    long value;

    public Node(int cnt, long value) {
        this.cnt = cnt;
        this.value = value;
    }
}