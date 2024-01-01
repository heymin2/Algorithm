import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Vector<Integer> v = new Vector<>();

        for(int i = 0; i < N; i++){
            int person = sc.nextInt();

            v.add(person);
        }

        v.sort(null);
        
        int[] result = new int[N];

        result[0] = v.get(0);

        int check = result[0];

        for(int i = 1; i < N; i++){
            result[i] = result[i-1] + v.get(i);

            check += result[i];
        }

        System.out.println(check);
    }
}