import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] check;
    static List<Integer>[] list;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1]; // 1부터
        check = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            check[e]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (check[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int num = q.poll();
            sb.append(num).append(" ");

            for (int i = 0; i < list[num].size(); i++) {
                check[list[num].get(i)]--;
                if (check[list[num].get(i)] == 0) {
                    q.offer(list[num].get(i));
                }
            }
        }

        System.out.println(sb);
    }
}