import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[2][500_001];

        q.add(new Node(N, 0, K));
        visit[0][N] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.path > 500_000) {
                System.out.println(-1);
                break;
            }

            if(visit[now.cnt % 2][now.path]) {
                System.out.println(now.cnt);
                break;
            }

            if(now.x * 2 <= 500_000 && !visit[(now.cnt+1)%2][now.x * 2]) {
                q.add(new Node(now.x * 2, now.cnt+1, now.path + now.cnt + 1));
                visit[(now.cnt+1)%2][now.x * 2] = true;
            }

            if(now.x + 1 <= 500_000 && !visit[(now.cnt+1)%2][now.x + 1]) {
                q.add(new Node(now.x + 1, now.cnt+1, now.path + now.cnt + 1));
                visit[(now.cnt+1)%2][now.x + 1] = true;
            }

            if(now.x - 1 >= 0 && !visit[(now.cnt+1)%2][now.x - 1]) {
                q.add(new Node(now.x - 1, now.cnt+1, now.path + now.cnt + 1));
                visit[(now.cnt+1)%2][now.x - 1] = true;
            }
        }
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