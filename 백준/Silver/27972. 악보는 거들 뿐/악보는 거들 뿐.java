import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();

        int [] p = new int[M];

        for(int i = 0; i < M; i++){
            p[i] = sc.nextInt();
        }

        int N = 1;
        int low = 1;
        int high = 1;

        for(int i = 1; i < M; i++){
            if(p[i-1] > p[i]){
                low++;
                high = 1;
                N = Math.max(N, low);
            }
            else if(p[i-1] < p[i]){
                high++;
                low = 1;
                N = Math.max(N, high);
            }
        }

        System.out.println(N);
    }
}
