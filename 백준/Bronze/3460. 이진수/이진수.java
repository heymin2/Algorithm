import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int cnt = 0;

            while(N != 0) {
                if(N % 2 == 1) {
                    sb.append(cnt).append(" ");
                }
                cnt++;
                N /= 2;
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}