import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        List<H> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            list.add(new H(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        list.sort(null);

        int cnt = 1, hour = list.get(0).e;

        for (int i = 1; i < N; i++) {
            if (hour <= list.get(i).s) {
                hour = list.get(i).e;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

class H implements Comparable<H> {
    int s, e;

    H(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(H o) {
        if (this.e == o.e) {
            return this.s - o.s;
        }
        return this.e - o.e;
    }
}