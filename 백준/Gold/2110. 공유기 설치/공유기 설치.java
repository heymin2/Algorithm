import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] X = new int[N];

        for(int i = 0; i < N; i++){
            X[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(X); // 1 2 4 8 9

        int low = 1; // 최소 거리 -> 1인 경우(모든 집에 설치한다는 의미)
        int high = X[N-1] - X[0] + 1; // 최대 거리

        while(low < high){
            int mid = (low + high) / 2;
            int count = 1;
            int lastLocate = X[0];

            for(int i = 1; i < N; i++){
                int locate = X[i];

                if(locate - lastLocate >= mid){
                    count++;
                    lastLocate = locate;
                }
            }

            if(count < C){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }
}
