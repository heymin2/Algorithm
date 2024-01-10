import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            Long num = Long.parseLong(br.readLine());

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
