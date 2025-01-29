import java.io.*;
import java.util.*;

public class Main {
  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Caw> caws = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int arrive = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            caws.add(new Caw(arrive, time));
        }

        caws.sort(null);

        int result = 0;
        for(int i = 0; i < N; i++) {
            Caw now = caws.get(i);

            if(result >= now.arrive) {
                result += now.time;
            }
            else {
                result = caws.get(i).arrive + caws.get(i).time;
            }
        }

        System.out.println(result);
    }
}

class Caw implements Comparable<Caw>{ 
    int arrive, time;

    public Caw(int arrive, int time) {
        this.arrive = arrive;
        this.time = time;
    }

    public int compareTo(Caw o) {
        return this.arrive - o.arrive;
    }
}