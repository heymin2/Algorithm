import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Map<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            Long num = sc.nextLong();

            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int max = 0; // 가장 많은 값 count
        long result = 0; // 가장 많은 값

        for(long idx: map.keySet()){ // map의 key값 나옴
            if(map.get(idx) > max){ // map의 value 비교
                max = map.get(idx);
                result = idx;
            }
            else if(map.get(idx) == max){
                result = Math.min(result, idx);
            }
        }

        System.out.println(result);
    }
}
