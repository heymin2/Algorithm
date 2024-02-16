import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<num> pq = new PriorityQueue<>();

        pq.offer(new num(N, 0));

        int[] visit = new int[N + 1];

        int[] dx = { 2, 3, -1 };
        int next;

        while (!pq.isEmpty()) {
            num now = pq.poll();

            sb.append(now.x);

            if (now.x == 1) {
                System.out.println(now.cnt);
                break;
            }

            for (int i = 0; i < 3; i++) {
                if (i == 2) {
                    next = now.x + dx[i];
                    if (visit[next] == 0) {
                        visit[next] = now.cnt + 1;
                        pq.offer(new num(next, now.cnt + 1));
                    } else if (visit[next] > now.cnt + 1) {
                        visit[next] = now.cnt + 1;
                        pq.offer(new num(next, now.cnt + 1));
                    }
                } else {
                    next = now.x / dx[i];
                    if (now.x % dx[i] == 0) {
                        if (visit[next] == 0) {
                            visit[next] = now.cnt + 1;
                            pq.offer(new num(next, now.cnt + 1));
                        } else if (visit[next] > now.cnt + 1) {
                            visit[next] = now.cnt + 1;
                            pq.offer(new num(next, now.cnt + 1));
                        }
                    }
                }
            }
        }
    }
}

class num implements Comparable<num> {
    int x, cnt;

    num(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(num o) {
        return this.cnt - o.cnt;
    }
}