import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> people = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int input = sc.nextInt();
            people.add(input);
        }

        people.sort((o1, o2) -> o2 - o1);

        long money = 0;

        for(int i = 0; i < N; i++){
            if(people.get(i) - i > 0){
                money += people.get(i) - i;
            }
        }

        System.out.println(money);
    }
}
