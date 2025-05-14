import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 키를 비교한 수

        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        int[] check = new int[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // A가 B 앞에
            int B = Integer.parseInt(st.nextToken());

            list.get(A).add(B);
            check[B]++;
        }

        int[] result = new int[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            if(check[i] == 0) {
                q.add(i);
                result[i] = 1;
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int value : list.get(now)) {
                check[value]--;
                if(check[value] == 0) {
                    q.add(value);
                    result[value] = result[now]+1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}