import java.util.*;
import java.io.*;

public class Main {
    static int mp, mf, ms, mv, price = -1, N;
    static List<Food> foods;
    static boolean[] check, min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()); // 최소 영양성분
        mp = Integer.parseInt(st.nextToken()); // 단백질
        mf = Integer.parseInt(st.nextToken()); // 지방
        ms = Integer.parseInt(st.nextToken()); // 탄수화물
        mv = Integer.parseInt(st.nextToken()); // 비타민

        foods = new ArrayList<>();
        check = new boolean[N];
        min = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int mpi = Integer.parseInt(st.nextToken());
            int mfi = Integer.parseInt(st.nextToken());
            int msi = Integer.parseInt(st.nextToken());
            int mvi = Integer.parseInt(st.nextToken());
            int pricei = Integer.parseInt(st.nextToken());
            foods.add(new Food(mpi, mfi, msi, mvi, pricei));
        }

        solve(0, 0, 0, 0, 0, 0);

        StringBuilder sb = new StringBuilder();

        sb.append(price).append("\n");

        if(price != -1) {
            for(int i = 0; i < N; i++) {
                if(min[i]) {
                    sb.append(i+1).append(" ");
                }
            }
        }

        System.out.println(sb);
    }

    static void solve(int idx, int p, int f, int s, int v, int c) {
        if(price != -1 && price <= c) {
            return;
        }

        if(p >= mp && f >= mf && s >= ms && v >= mv) {
            for(int i = 0; i < N; i++) {
                min[i] = check[i];
            }
            price = c;
            return;
        }

        for(int i = idx; i < N; i++) {
            check[i] = true;
            Food food = foods.get(i); 
            solve(i+1, p + food.mp, f + food.mf, s + food.ms, v + food.mv, c + food.price);
            check[i] = false;
        }
    }
}           

class Food {
    int mp, mf, ms, mv, price;

    public Food(int mp, int mf, int ms, int mv, int price) {
        this.mp = mp;
        this.mf = mf;
        this.ms = ms;
        this.mv = mv;
        this.price = price;
    }
}