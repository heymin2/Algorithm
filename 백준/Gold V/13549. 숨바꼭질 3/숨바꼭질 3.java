import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Subin> q = new PriorityQueue<>();
        boolean[] visit = new boolean[100_001];

        q.offer(new Subin(N, 0));
        visit[N] = true;

        int[] dx = {2, -1, 1}; 

        while (!q.isEmpty()) {
            Subin now = q.poll();

            if (now.x == K) {
                System.out.println(now.cnt);
                break;
            }

            for (int i = 0; i < 3; i++) {
                if(i == 0){
                    int next = now.x * dx[i];

                    if (next < 0 || next > 100_000 || visit[next])
                        continue;
                    visit[next] = true;
                    q.offer(new Subin(next, now.cnt));
                }
                else{
                    int next = now.x + dx[i];

                    if (next < 0 || next > 100_000 || visit[next])
                        continue;
                    visit[next] = true;
                    q.offer(new Subin(next, now.cnt + 1));
                }
            }
        }
    }
}

class Subin implements Comparable<Subin>{
    int x, cnt;

    Subin(int x, int cnt) {
        this.x = x;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Subin o) {
        if(this.cnt == o.cnt){
            return this.x - o.x;
        }
        return this.cnt - o.cnt;
    }
}