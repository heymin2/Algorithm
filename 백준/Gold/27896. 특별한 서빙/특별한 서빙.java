import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 학생수
        int M = Integer.parseInt(st.nextToken()); // 불만도 (넘기면 안됨)

        int[] student = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) { // 학생들의 불만도
            student[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int total = 0; // 파묻튀면 +, 가지면 -
        for(int i = 0 ; i < N; i++) {
            int next = student[i];
            if(total + next < M) {
                pq.add(next);
                total += next;
            }
            else {
                if(pq.isEmpty()) {
                    total -= next;
                }
                else {
                    int now = pq.poll(); // 가장 최근 친구
                    if(now > next) {
                        pq.add(next);
                        total += next - (now*2);
                    }
                    else {
                        pq.add(now);
                        total -= next;
                    }
                }
            }
        }

        System.out.println(N-pq.size());
    }
}