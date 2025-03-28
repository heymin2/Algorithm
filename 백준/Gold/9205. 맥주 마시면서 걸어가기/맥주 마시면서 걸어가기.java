import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[][] store = new int[n+1][2];

            st = new StringTokenizer(br.readLine()); // 상근이네 집
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine()); // 편의점
                store[i][0] = Integer.parseInt(st.nextToken());
                store[i][1] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine()); // 페스티벌
            store[n][0] = Integer.parseInt(st.nextToken());
            store[n][1] = Integer.parseInt(st.nextToken());

            Queue<Status> q = new ArrayDeque<>();
            q.add(new Status(x, y));
            boolean[] visit = new boolean[n+1];
            boolean flag = false;

            while(!q.isEmpty()) {
                Status now = q.poll();

                if(now.x == store[n][0] && now.y == store[n][1]) {
                    flag = true;
                    break;
                }

                for(int i = 0; i <= n; i++) {
                    if(!visit[i]){
                        int distance = Math.abs(now.x - store[i][0]) + Math.abs(now.y - store[i][1]);

                        if(distance <= 1000) {
                            q.add(new Status(store[i][0], store[i][1]));
                            visit[i] = true;
                        }
                    }
                }
            }

            sb.append(flag ? "happy\n" : "sad\n");
        }
        System.out.println(sb);
    }
}

class Status {
    int x, y;

    public Status(int x, int y) {
        this.x = x;
        this.y = y;
    }
}