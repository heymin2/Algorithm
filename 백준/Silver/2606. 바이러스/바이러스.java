import java.util.Scanner;

public class Main {
    static int N;
    static int[][] computer;
    static boolean[] check;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        computer = new int[N+1][N+1];
        check = new boolean[N+1];

        int count = sc.nextInt();

        for(int i = 0; i < count; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            computer[a][b] = computer[b][a] = 1;
        }
        
        dfs(1);

        System.out.println(result);
    }

    static void dfs(int idx){
        check[idx] = true;

        for(int i = 2; i <= N; i++){
            if(computer[idx][i] == 1 && !check[i]){
                result++;
                dfs(i);
            }
        }
    }
}
