import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 나무 수
        int M = Integer.parseInt(st.nextToken()); // 가져가려고 하는 나무 길이
        
        int[] high = new int[N]; // 나무 높이

        st = new StringTokenizer(br.readLine());

        int start = 0;
        int end = 0;

        for(int i = 0; i < N; i++){
            high[i] = Integer.parseInt(st.nextToken());

            if(end < high[i]){
                end = high[i];
            }
        }

        int result = 0;

        while(start <= end){
            long total = 0;
            int mid = (start + end) / 2;

            for(int i = 0; i < N; i++){
                if(high[i] > mid) total += high[i] - mid;
            }

            if(total < M){
                end = mid - 1;
            } else{
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);

    }
}
