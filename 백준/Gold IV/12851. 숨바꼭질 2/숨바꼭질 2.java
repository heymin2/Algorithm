import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int MAX_SIZE = 100_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Subin> q = new PriorityQueue<>();
        int [] visit = new int[MAX_SIZE+1];

        q.offer(new Subin(N, 0));
        visit[N] = 0;

        int[] dx = { 2, -1, 1}; 
        int min = MAX_SIZE+1;
        int min_cnt = 0;

        while (!q.isEmpty()) {
            Subin now = q.poll();

            if (now.x == K) {
                if(min > now.cnt){
                    min = now.cnt;
                    min_cnt = 1;
                }
                else if(min == now.cnt){
                    min_cnt++;
                }
                else{
                    break;
                }
            }

            for (int i = 0; i < 3; i++) {
                if(i == 0){
                    int next = now.x * dx[i];
                    int nextCnt = now.cnt + 1;

                    if (next < 0 || next > MAX_SIZE)
                        continue;

                    if(visit[next] != 0 && visit[next] < nextCnt) continue;
                    visit[next] = nextCnt;
                    q.offer(new Subin(next, nextCnt));
                }
                else{
                    int next = now.x + dx[i];
                    int nextCnt = now.cnt + 1;

                    if (next < 0 || next > MAX_SIZE )
                        continue;

                    if(visit[next] != 0 && visit[next] < nextCnt) continue;
                    visit[next] = nextCnt;
                    q.offer(new Subin(next, now.cnt + 1));
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();

        sb.append(min).append("\n");
        sb.append(min_cnt);

        System.out.println(sb);
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