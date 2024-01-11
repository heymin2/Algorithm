import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수 
        int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수

        long[] arr = new long[K];

        long low = 1;
        long high = 0;
        long mid = 0;

        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(br.readLine());

            high = Math.max(high, arr[i]);
        }

        long result = 0;

        while(low <= high){
            mid = (low + high) / 2;
            long total = 0;

            for(long value : arr){
                total += value / mid;
            }

            if(total >= N){
                low = mid + 1;
            } 
            else{
                high = mid - 1;
            }
        }

        result = (low + high) / 2;

        System.out.println(result);
    }
}
