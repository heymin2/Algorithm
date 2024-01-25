import java.util.*;
 
public class Main {

    static int f, s, g, u, d;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        f = scan.nextInt();
        s = scan.nextInt();
        g = scan.nextInt();
        u = scan.nextInt();
        d = scan.nextInt();
 
        visited = new boolean[f + 1];
        int result = bfs();

        if(result < 0) System.out.println("use the stairs");
        else System.out.println(result);
    }
 
    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, 0));
        visited[s] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();
            if(current.x == g) return current.cost;

            if(current.x + u <= f && visited[current.x + u] == false) {
                q.offer(new Node(current.x + u, current.cost + 1));
                visited[current.x + u] = true;
            }
            if(current.x - d >= 1 && visited[current.x - d] == false) {
                q.offer(new Node(current.x - d, current.cost + 1));
                visited[current.x - d] = true;
            }
        }
        return -1;
    }

    public static class Node {
        int x;
        int cost;

        public Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}

