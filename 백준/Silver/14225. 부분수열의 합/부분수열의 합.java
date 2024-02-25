import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visit, check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        visit = new boolean[N];
        check = new boolean[100_000 * 20 + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        re(0, 0);

        for(int i = 1; i < 100_000 * 20 + 1; i++){
            if(!check[i]){
                System.out.println(i);
                break;
            }
        }
    }

    static void re(int cnt, int sum){
        if(cnt == N){
            check[sum] = true;
            return;
        }

        visit[cnt] = true;
        re(cnt+1, sum + arr[cnt]);

        visit[cnt] = false;
        re(cnt+1, sum);
    }
}