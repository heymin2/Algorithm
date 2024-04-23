import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, w, L;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            truck.add(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> q = new ArrayDeque();

        for(int i = 0; i < w; i++) {
            q.add(0);
        }

        int nowW = 0;
        int result = 0;

       while(!q.isEmpty()) {
            result++;

            nowW -= q.poll();

            if(!truck.isEmpty()) {
                if(truck.peek() + nowW <= L) {
                    nowW += truck.peek();
                    q.add(truck.poll());
                }
                else{
                    q.offer(0);
                }
            }
       }

       System.out.println(result);
    }
}