import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Ballon> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            q.add(new Ballon(i, Integer.parseInt(st.nextToken())));
        }
   
        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            Ballon now = q.poll();
            sb.append(now.idx).append(" ");

            if(q.isEmpty()) break;

            int move = now.move;
            if(move > 0) {
                move--;
                for(int i = 0; i < move; i++) {
                    q.add(q.poll());
                }
            }
            else {
                move = -move;
                for(int i = 0; i < move; i++) {
                    q.push(q.pollLast());
                }
            }
        }
        
        System.out.println(sb);
    }
}

class Ballon{
    int idx;
    int move;

    public Ballon(int idx, int move) {
        this.idx = idx;
        this.move = move;
    }
}