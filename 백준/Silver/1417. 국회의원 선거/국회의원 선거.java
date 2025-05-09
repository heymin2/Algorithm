import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(new Node(i+1, Integer.parseInt(br.readLine())));
        }

        int result = 0;
        while(true) {
            list.sort(null);

            if(list.get(0).idx == 1) {
                System.out.println(result);
                break;
            }

            list.get(0).value--;
            result++;

            for(int i = 1; i < list.size(); i++) {
                if(list.get(i).idx == 1) {
                    list.get(i).value++;
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    int idx, value;

    public Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }

    public int compareTo(Node o) {
        if(o.value == this.value) {
            return o.idx - this.idx;
        }
        return o.value - this.value;
    }
}