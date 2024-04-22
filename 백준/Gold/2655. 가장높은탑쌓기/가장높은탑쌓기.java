import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        List<Top> list = new ArrayList<>();
        list.add(new Top(0, 0, 0, 0));

        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.add(new Top(i, area, h, w));
        }

        list.sort(null);

        int[] dp = new int[N+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < i; j++) {
                if(list.get(i).area > list.get(j).area) {
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).h);
                }
            }
        }

        int maxH = 0;

        for(int i = 0; i <= N; i++) {
            if(maxH < dp[i]) maxH = dp[i];
        }

        int idx = N;
        ArrayDeque<Integer> st = new ArrayDeque<>();

        while(idx != 0) {
            if(maxH == dp[idx]) {
                st.add(list.get(idx).idx);
                maxH -= list.get(idx).h;
            }
            idx--;
        }

        sb.append(st.size()).append("\n");

        while(!st.isEmpty()){
            sb.append(st.pollLast()).append("\n");
        }

        System.out.println(sb);
    }
}

class Top implements Comparable<Top> {
    int idx, area, h, w;

    Top(int idx, int area, int h, int w) {
        this.idx = idx;
        this.area = area;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Top o) {
        return w - o.w;
    }
}