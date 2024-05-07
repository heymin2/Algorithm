import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
 
class Main {
    static int N, arr[][], min;
    static int[] check;
 
      public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        N = Integer.parseInt(br.readLine());
 
        arr = new int[N][N];
        check = new int[N/2];
 
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
 
        min = Integer.MAX_VALUE;
        select(0, 0);
        System.out.println(min);
    }
 
    static void select(int cnt, int start) {
        if(cnt == N/2) {
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();
             
            boolean[] visit  = new boolean[N];
            for(int i = 0; i < N/2; i++) {
                A.add(check[i]);
                visit[check[i]] = true;
            }
 
            for(int i = 0; i < N; i++) {
                if(!visit[i]) {
                    B.add(i);
                }
            }
 
            int s = Math.abs(sum(A) - sum(B));
            min = Math.min(min, s);
 
            return;
        }
 
        for(int i = start; i < N; i++) {
            check[cnt] = i;
            select(cnt+1, i+1);
        }
    }
 
    static int sum(List<Integer> list) {
        int s = 0;
 
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size(); j++) {
                s += arr[list.get(i)][list.get(j)];
            }
        }
 
        return s;
    }
}