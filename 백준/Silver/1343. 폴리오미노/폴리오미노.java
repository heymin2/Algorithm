import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String A = "AAAA";
        String B = "BB";

        input = input.replace("XXXX", A);
        input = input.replace("XX", B);

        if(input.contains("X")){
            System.out.println("-1");
        }
        else{
            System.out.println(input);
        }
    }
}