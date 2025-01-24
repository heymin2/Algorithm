import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 학생 수

        List<Student> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());;
            int m = Integer.parseInt(st.nextToken());;
            int s = Integer.parseInt(st.nextToken());;

            list.add(new Student(idx, k, e, m, s));
        }

        list.sort((o1, o2) -> o1.idx - o2.idx);
        list.sort((o1, o2) -> o2.k - o1.k);
        sb.append(list.get(0).idx).append(" ");
        list.remove(0);

        list.sort((o1, o2) -> o1.idx - o2.idx);
        list.sort((o1, o2) -> o2.e - o1.e);
        sb.append(list.get(0).idx).append(" ");
        list.remove(0);

        list.sort((o1, o2) -> o1.idx - o2.idx);
        list.sort((o1, o2) -> o2.m - o1.m);
        sb.append(list.get(0).idx).append(" ");
        list.remove(0);

        list.sort((o1, o2) -> o1.idx - o2.idx);
        list.sort((o1, o2) -> o2.s - o1.s);
        sb.append(list.get(0).idx);
        list.remove(0);

        System.out.println(sb);
    }
}

class Student {
    int idx, k, e, m, s;

    public Student(int idx, int k, int e, int m, int s) {
        this.idx = idx;
        this.k = k;
        this.e = e;
        this.m = m;
        this.s = s;
    }
}