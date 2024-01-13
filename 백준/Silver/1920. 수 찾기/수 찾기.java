import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] num = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int M = Integer.parseInt(br.readLine());
        long[] mum = new long[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            mum[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            int low = 0;
            int high = num.length -1;
            int check = 0;

            while(low <= high){
                int mid = (low + high) / 2;

                if(mum[i] < num[mid]){
                    high = mid - 1;
                }
                else if(mum[i] > num[mid]){
                    low = mid + 1;
                }
                else{
                    check = 1;
                    break;
                }
            }
            if(check == 1){
                System.out.println("1");
            }
            else{
                System.out.println("0");
            }
        }
    }
}
