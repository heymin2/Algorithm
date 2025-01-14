import java.util.*;
import java.io.*;

public class Main {
    static int mp, mf, ms, mv, price = -1, N;
    static List<Food> food;
    static boolean[] check;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()); // 최소 영양성분
        mp = Integer.parseInt(st.nextToken()); // 단백질
        mf = Integer.parseInt(st.nextToken()); // 지방
        ms = Integer.parseInt(st.nextToken()); // 탄수화물
        mv = Integer.parseInt(st.nextToken()); // 비타민

        food = new ArrayList<>();
        check = new boolean[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int mpi = Integer.parseInt(st.nextToken());
            int mfi = Integer.parseInt(st.nextToken());
            int msi = Integer.parseInt(st.nextToken());
            int mvi = Integer.parseInt(st.nextToken());
            int pricei = Integer.parseInt(st.nextToken());
            food.add(new Food(mpi, mfi, msi, mvi, pricei));
        }

        solve(0);

        StringBuilder sb = new StringBuilder();

        sb.append(price).append("\n");

        if(price != -1) {
            for(int i = 0; i < list.size(); i++) {
                sb.append(list.get(i)).append(" ");
            }
        }

        System.out.println(sb);
    }

    static void solve(int idx) {
        if(idx == N) {
            calculate();
            return;
        }

        check[idx] = true;
        solve(idx+1);
        
        check[idx] = false;
        solve(idx+1);
    }

    static void calculate() {
        int mpi = 0, mfi = 0, msi = 0, mvi = 0, pricei = 0;
        List<Integer> currentList = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            if(check[i]) {
                mpi += food.get(i).mp;
                mfi += food.get(i).mf;
                msi += food.get(i).ms;
                mvi += food.get(i).mv;
                pricei += food.get(i).price;
                currentList.add(i + 1);
            }
        }

        if(mpi >= mp && mfi >= mf && msi >= ms && mvi >= mv) {
            if(price == -1 || (price != -1 && price > pricei) || (price == pricei && isLexicographicallySmaller(currentList, list))) {
                price = pricei;
                list = new ArrayList<>(currentList);  
            }
        }
    }

    // 사전 순서 비교 메서드
    static boolean isLexicographicallySmaller(List<Integer> current, List<Integer> best) {
        if (best == null) return true;  // 초기값일 경우 true 반환
        for (int i = 0; i < current.size(); i++) {
            if (i >= best.size()) return false;  // current가 더 길 경우
            if (!current.get(i).equals(best.get(i))) {
                return current.get(i) < best.get(i);  // 사전 순서 비교
            }
        }
        return current.size() < best.size();  // 길이 비교
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