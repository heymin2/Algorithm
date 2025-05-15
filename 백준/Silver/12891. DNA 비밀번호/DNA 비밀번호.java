import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
      
        String str = br.readLine();

        int[] arr = new int[4];
        st = new StringTokenizer(br.readLine());
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        arr[2] = Integer.parseInt(st.nextToken());
        arr[3] = Integer.parseInt(st.nextToken());

        int[] newArr = new int[4];

        for(int i = 0; i < P; i++) {
            if(str.charAt(i) == 'A') newArr[0]++;
            else if(str.charAt(i) == 'C') newArr[1]++;
            else if(str.charAt(i) == 'G') newArr[2]++;
            else if(str.charAt(i) == 'T') newArr[3]++;
        }

        int result = 0;
        if(arr[0] <= newArr[0] && arr[1] <= newArr[1] &&
            arr[2] <= newArr[2] && arr[3] <= newArr[3]) {
            result++;
        }

        for(int i = P; i < S; i++) {
            // 맨 앞 제거
            if(str.charAt(i-P) == 'A') newArr[0]--;
            else if(str.charAt(i-P) == 'C') newArr[1]--;
            else if(str.charAt(i-P) == 'G') newArr[2]--;
            else if(str.charAt(i-P) == 'T') newArr[3]--;

            // 맨 뒤 추가
            if(str.charAt(i) == 'A') newArr[0]++;
            else if(str.charAt(i) == 'C') newArr[1]++;
            else if(str.charAt(i) == 'G') newArr[2]++;
            else if(str.charAt(i) == 'T') newArr[3]++;

            // 계산
            if(arr[0] <= newArr[0] && arr[1] <= newArr[1] &&
            arr[2] <= newArr[2] && arr[3] <= newArr[3]) {
                result++;
            }
        }

        System.out.println(result);
    }
}