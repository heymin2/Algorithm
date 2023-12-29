import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> rope = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int input = sc.nextInt();
            rope.add(input);
        }

        rope.sort((o1, o2) -> o2 - o1);

        int max = 0;

        for(int i = 0; i < rope.size(); i++){
            int value = rope.get(i) * (i+1);
            if(value > max){
                max = value;
            }
        }

        System.out.println(max);
    }
}
