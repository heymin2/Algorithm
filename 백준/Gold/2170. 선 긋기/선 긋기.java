import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y));
        }

        list.sort(null);

        int first = list.get(0).x;
        int last = list.get(0).y;
        int result = 0;

        for(int i = 1; i < N; i++) {
            Node now = list.get(i);

            if(last >= now.x && last < now.y) {
                last = now.y;
            }
            else if(last < now.x) {
                result += last - first;
                first = now.x;
                last = now.y;
            }
        }

        result += last - first;
        System.out.println(result);
    }
}

class Node implements Comparable<Node> {
    int x, y;

    public Node(int x, int y) { 
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node o) {
        return this.x - o.x;
    }
}