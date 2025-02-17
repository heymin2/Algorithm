import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 굴다리의 길이
        int M = Integer.parseInt(br.readLine()); // 가로등의 개수
        int[] arr = new int[M]; // 가로등 위치
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N;
        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            boolean flag = true;
            int prev = 0;
            for(int i = 0; i < M; i++) {
                if(arr[i] - mid <= prev) prev = arr[i] + mid;
                else flag = false;
            }
            if(prev < N) flag = false;

            if(!flag){
                left = mid + 1;
            }
            else {
                right = mid - 1;
                result = mid;
            }
        }

        System.out.println(result);
	}
}