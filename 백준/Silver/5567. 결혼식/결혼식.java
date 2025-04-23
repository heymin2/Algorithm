import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<Integer>());
        }

        boolean[] visit = new boolean[N+1];
        visit[1] = true;

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        for(int i : list.get(1)) {
            visit[i] = true;
        }

        int cnt = list.get(1).size();

        for(int i : list.get(1)) {
            List<Integer> now = list.get(i);

            for(int j : now) {
                if(!visit[j]) {
                    cnt++;
                    visit[j] = true;
                }
            }
        }

        System.out.println(cnt);
    }
}
