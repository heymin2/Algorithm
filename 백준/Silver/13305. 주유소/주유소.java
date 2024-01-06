import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        long[] distance = new long[N-1];
        long[] pay = new long[N];

        for(int i = 0; i < N-1; i++){
            distance[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++){
            pay[i] = sc.nextInt();
        }

        long sum = pay[0] * distance[0];
        long cntPay = pay[0];

        for(int i = 1; i < N-1; i++){
            if(cntPay > pay[i]) cntPay = pay[i];
            sum += cntPay * distance[i];
        }

        System.out.println(sum);
        
    }
}
