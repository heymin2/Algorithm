import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(0);
            System.out.println(1);
        } else {
            PriorityQueue<num> pq = new PriorityQueue<>();

            pq.offer(new num(N, 0, 0));

            int[] visit = new int[N + 1];

            int[] dx = { 2, 3, -1 };
            int next;

            int cnt = 0;

            List<num> list = new ArrayList<>();

            while (!pq.isEmpty()) {
                list.add(pq.peek());
                num now = pq.poll();

                if (now.x == 1) {
                    cnt = now.cnt;
                    break;
                }

                for (int i = 0; i < 3; i++) {
                    if (i == 2) {
                        next = now.x + dx[i];
                        if (visit[next] == 0) {
                            visit[next] = now.cnt + 1;
                            pq.offer(new num(next, now.cnt + 1, now.x));
                        } else if (visit[next] > now.cnt + 1) {
                            visit[next] = now.cnt + 1;
                            pq.offer(new num(next, now.cnt + 1, now.x));
                        }
                    } else {
                        next = now.x / dx[i];
                        if (now.x % dx[i] == 0) {
                            if (visit[next] == 0) {
                                visit[next] = now.cnt + 1;
                                pq.offer(new num(next, now.cnt + 1, now.x));
                            } else if (visit[next] > now.cnt + 1) {
                                visit[next] = now.cnt + 1;
                                pq.offer(new num(next, now.cnt + 1, now.x));
                            }
                        }
                    }
                }

            }

            sb.append(cnt).append("\n");

            int[] arr = new int[cnt];
            arr[0] = 1;

            next = list.get(list.size() - 1).prev;
            for (int i = 1; i < cnt; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).x == next) {
                        arr[i] = list.get(j).x;
                        next = list.get(j).prev;
                    }
                }
            }

            sb.append(N).append(" ");

            for (int i = arr.length - 1; i >= 0; i--) {
                sb.append(arr[i]).append(" ");
            }

            System.out.println(sb);
        }
    }
}

class num implements Comparable<num> {
    int x, cnt, prev;

    num(int x, int cnt, int prev) {
        this.x = x;
        this.cnt = cnt;
        this.prev = prev;
    }

    @Override
    public int compareTo(num o) {
        return this.cnt - o.cnt;
    }
}