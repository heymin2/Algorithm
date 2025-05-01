import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 보석 색 수

        int[] arr = new int[M];
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int low = 1;
        int high = arr[arr.length-1];
       
        while(low < high) {
            int mid = (low + high) / 2;
            long sum = 0;

            for(int a : arr) {
                if(a % mid == 0) {
                    sum += a / mid;
                }
                else {
                    sum += a / mid + 1;
                }
            }

            if(sum > N) {
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        System.out.println(low);
    }
}