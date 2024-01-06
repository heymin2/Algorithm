import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] distance = new int[N-1];
        int[] pay = new int[N];

        for(int i = 0; i < N-1; i++){
            distance[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++){
            pay[i] = sc.nextInt();
        }

        int sum = pay[0] * distance[0];
        int cntPay = pay[0];

        for(int i = 1; i < N-1; i++){
            if(cntPay > pay[i]) cntPay = pay[i];
            sum += cntPay * distance[i];
        }

        System.out.println(sum);
        
    }
}
