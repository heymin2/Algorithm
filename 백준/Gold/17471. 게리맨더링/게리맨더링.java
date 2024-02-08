import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, min = Integer.MAX_VALUE; // 구역수
    static List<ArrayList<Integer>> list; // 구역별 어디랑 인접한지
    static int[] arr; // 인구수
    static boolean[] select; // 부분집합 선택했는지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        arr = new int[N];
        select = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                int value = Integer.parseInt(st.nextToken());
                list.get(i).add(value);
            }
        }

        re(0);
        if (min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }

    static void re(int cnt) {
        if (cnt == N) {
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                if (select[i]) {
                    a.add(i + 1);
                } else {
                    b.add(i + 1);
                }
            }

            if (a.isEmpty() || b.isEmpty()) {
                return;
            }

            if (check(a) && check(b)) {
                calculate();
            }
            return;
        }

        select[cnt] = true;
        re(cnt + 1);
        select[cnt] = false;
        re(cnt + 1);
    }

    static boolean check(List<Integer> area) {
        boolean[] visit = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(area.get(0) - 1);
        visit[area.get(0) - 1] = true;

        int cnt = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 0; i < list.get(now).size(); i++) {
                int next = list.get(now).get(i);

                if (!visit[next - 1] && area.contains(next)) {
                    q.offer(next - 1);
                    visit[next - 1] = true;
                    cnt++;
                }
            }
        }

        if (cnt == area.size()) {
            return true;
        }
        return false;
    }

    static void calculate() {
        int a = 0, b = 0;
        for (int i = 0; i < N; i++) {
            if (select[i]) {
                a += arr[i];
            } else {
                b += arr[i];
            }
        }
        min = Math.min(min, Math.abs(a - b));
    }
}