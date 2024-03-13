import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, X; // 학생수, 도로수, 목적지
    static List<party>[] list1, list2; // 정방향, 역방향
    static int[] visit, visit2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list1 = new ArrayList[N + 1];
        list2 = new ArrayList[N + 1];
        visit = new int[N + 1];
        visit2 = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list1[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            list1[start].add(new party(end, time));
            list2[end].add(new party(start, time));
        }

        visit = toX(X, list1);
        visit2 = toX(X, list2);

        int result = 0;

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, visit[i] + visit2[i]);
        }

        System.out.println(result);
    }

    static int[] toX(int k, List<party>[] list) {
        PriorityQueue<party> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N + 1];
        int[] v = new int[N + 1];

        Arrays.fill(v, Integer.MAX_VALUE);

        pq.offer(new party(k, 0));
        v[k] = 0;

        while (!pq.isEmpty()) {
            party now = pq.poll();

            if (visited[now.y])
                continue;
            
            visited[now.y] = true;

            for (int i = 0; i < list[now.y].size(); i++) {
                party next = list[now.y].get(i);

                if (v[next.y] > v[now.y] + next.cost) { // 현재비용 + 다음비용
                    v[next.y] = v[now.y] + next.cost;
                    pq.offer(new party(next.y, v[next.y]));
                } 
            }
        }

        return v;
    }
}

class party implements Comparable<party>{
    int y, cost;

    party(int y, int cost) {
        this.y = y;
        this.cost = cost;
    }

    @Override
    public int compareTo(party o) {
        return this.cost - o.cost;
    }
}