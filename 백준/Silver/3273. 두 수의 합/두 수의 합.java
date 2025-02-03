import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 0, right = n-1;
        int result = 0;
        while(left < right) {
            int now = arr[left] + arr[right];
            if(now < x) {
                left++;
            }
            else if(now == x) {
                result++;
                left++;
                right--;
            }
            else {
                right--;
            }
        }

        System.out.println(result);
    }
}