import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Num> pQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                pQ.offer(new Num(x, Math.abs(x)));
            } else {
                if (pQ.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pQ.poll().num).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}

class Num implements Comparable<Num> {
    int num;
    int abs;

    Num(int num, int abs) {
        this.num = num;
        this.abs = abs;
    }

    @Override
    public int compareTo(Num o) {
        if (this.abs == o.abs) {
            return this.num - o.num;
        }
        return this.abs - o.abs;
    }
}