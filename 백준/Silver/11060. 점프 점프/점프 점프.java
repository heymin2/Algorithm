import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Node> q = new ArrayDeque<>();
        int[] visit = new int[N];

        for(int i = 0; i < N; i++) {
            visit[i] = Integer.MAX_VALUE;
        }

        q.add(new Node(0, 0));
        visit[0] = arr[0];

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.x == N-1) {
                System.out.println(now.cnt);
                return;
            }

            for(int i = 1; i <= arr[now.x]; i++) {
                if(now.x + i < N && visit[now.x + i] > now.cnt+1) {
                    q.add(new Node(now.x + i, now.cnt+1));
                    visit[now.x+i] = now.cnt+1;
                }
            }
        }

        System.out.println(-1);
    }
}

class Node {
    int x, cnt;

    public Node(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }
}