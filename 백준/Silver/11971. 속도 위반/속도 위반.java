import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] road = new int[101];
        int now = 1;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int leng = Integer.parseInt(st.nextToken());
            int kmh = Integer.parseInt(st.nextToken());

            for(int j = now; j < now+leng; j++) {
                road[j] = kmh;
            }

            now += leng;
        }

        int max = 0;
        now = 1;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int carL = Integer.parseInt(st.nextToken());
            int carH = Integer.parseInt(st.nextToken());

            for(int j = now; j < now+carL; j++) {
                if(road[j] < carH) max = Math.max(max, carH - road[j]);
            }

            now += carL;
        }

        System.out.println(max);
    }
}