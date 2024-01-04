import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Vector<Integer> v = new Vector<>();

        for(int i = 0; i < N; i++){
            int a = sc.nextInt();
            v.add(a);
        }

        v.sort((o1, o2) -> o2-o1);

        int cost = 0;
        int idx = 1;

        for(int i = 0; i < N; i++){
            if(idx % 3 == 0){
                idx = 1;
            } else{
                cost += v.get(i);
                idx++;
            }
        }

        System.out.println(cost);
    }
}
