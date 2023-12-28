import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int check = 0;

        while(true){
            if(n % 5 == 0){
                check += n / 5;
                System.out.println(check);
                break;
            }
            else{
               n -= 2;
               check++;
            }
            if(n < 0){
                System.out.println("-1");
                break;
            }
            else if(n == 0){
                System.out.println(check);
                break;
            }
        }
    }
}
