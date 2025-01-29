import java.io.*;
import java.util.*;

public class Main {
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Office> caws = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            caws.add(new Office(start, end));
        }

        caws.sort(null);

        int result = 0; int cnt = 0;
        for(int i = 0; i < N; i++) {
            Office now = caws.get(i);

            if(result <= now.start) {
                result = now.end;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}

class Office implements Comparable<Office>{ 
    int start, end;

    public Office(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Office o) {
        if(this.end == o.end) {
            return this.start - o.start;
        }
        return this.end - o.end;
    }
}