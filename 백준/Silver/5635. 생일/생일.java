import java.util.*;
import java.io.*;

public class Main {
    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Node[] students = new Node[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            students[i] = new Node(name, year, month, day);
        }
       
        Arrays.sort(students);

        StringBuilder sb = new StringBuilder();

        sb.append(students[N-1].name).append("\n").append(students[0].name);
        System.out.println(sb);
    }
}

class Node implements Comparable<Node> {
    String name;
    int day, month, year;

    public Node(String name, int year, int month, int day) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public int compareTo(Node o) {
        if(this.year == o.year) {
            if(this.month == o.month) {
                return this.day - o.day;
            }
            return this.month - o.month;
        }
        return this.year - o.year;
    }
}