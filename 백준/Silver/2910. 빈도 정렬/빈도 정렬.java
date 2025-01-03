import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 최대 개수
        int C = Integer.parseInt(st.nextToken()); // 이 값보다 클수없음

        st = new StringTokenizer(br.readLine());
        List<Bindo> list = new ArrayList<>();

        // 풀이
        for(int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            boolean flag = false;

            for(int j = 0; j < list.size(); j++) {
                if(list.get(j).value == value) {
                    list.get(j).cnt = list.get(j).cnt + 1;
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                list.add(new Bindo(value, 1, i));
            }
        }
        
        list.sort(null);

        StringBuilder sb = new StringBuilder();

        for(Bindo bindo : list) {
            for(int i = 0; i < bindo.cnt; i++) sb.append(bindo.value).append(" ");
        }

        // 정답
        System.out.println(sb);
    }
}

class Bindo implements Comparable<Bindo> {
    int value, cnt, order;

    public Bindo(int value, int cnt, int order) {
        this.value = value;
        this.cnt = cnt;
        this.order = order;
    }

    public int compareTo(Bindo o) {
        if(this.cnt == o.cnt) {
            return this.order - o.order;
        }

        return o.cnt - this.cnt;
    }

    @Override
    public String toString() {
        return value + " " + cnt + " " + order;
    }
}