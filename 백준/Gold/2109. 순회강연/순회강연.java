import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Info> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Info(p, d));
        }

        list.sort(null);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            Info now = list.get(i);

            if(pq.size() < now.d) pq.add(now.p);
            else {
                int value = pq.poll();

                if(value < now.p) pq.add(now.p);
                else pq.add(value);
            }
        }

        int money = 0;
        while(!pq.isEmpty()) {
            money += pq.poll();
        }

        System.out.println(money);
    }
}

class Info implements Comparable<Info> {
    int p, d;

    public Info(int p, int d) {
        this.p = p;
        this.d = d;
    }

    public int compareTo(Info o) {
        return this.d - o.d;
    }
}