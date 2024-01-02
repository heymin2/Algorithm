import java.util.Scanner;

public class Main {
    static int result = 0;
    static int N;
    static int[] T;
    static int[] P;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        T = new int[N];
        P = new int[N];

        for(int i = 0; i < N; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        dfs(0, 0);

        System.out.println(result);
    }
    
    static void dfs(int idx, int pay){
        if(idx >= N){
            result = Math.max(result, pay);
            return;
        }

        if(idx + T[idx] <= N){
            dfs(idx+T[idx], pay + P[idx]);
        }
        else{
            dfs(idx+T[idx], pay);
        }
        dfs(idx+1, pay);
    }
}
