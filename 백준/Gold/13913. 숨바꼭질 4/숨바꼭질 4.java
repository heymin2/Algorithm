import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Node> q = new ArrayDeque<>();
        boolean[] visit = new boolean[100_001];
        q.add(new Node(N, 0, -1));

        ArrayDeque<Node> list = new ArrayDeque<>();

        while(!q.isEmpty()) {
            Node now = q.poll();

            list.push(now);

            if(now.x == K) {
                sb.append(now.cnt).append("\n");
                break;
            }

            if(now.x * 2 <= 100_000 && !visit[now.x*2]) {
                q.add(new Node(now.x * 2, now.cnt+1, now.x));
                visit[now.x*2] = true;
            }

            if(now.x + 1 <= 100_000 && !visit[now.x+1]) {
                q.add(new Node(now.x + 1, now.cnt+1, now.x));
                visit[now.x+1] = true;
            }

            if(now.x - 1 >= 0 && !visit[now.x-1]) {
                q.add(new Node(now.x - 1, now.cnt+1, now.x));
                visit[now.x-1] = true;
            }
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        Node now = list.pop();
        stack.push(now.x);

        int next = now.path;
        int cnt = now.cnt;

        while(!list.isEmpty()) {
            now = list.pop();

            if(now.x == next && now.cnt == cnt - 1) {
                stack.push(now.x);

                next = now.path;
                cnt = now.cnt;
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}

class Node{
    int x, cnt, path;

    public Node(int x, int cnt, int path) {
        this.x = x;
        this.cnt = cnt;
        this.path = path;
    }
}