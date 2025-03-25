import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> fruit = new HashMap<>();
        int max = 0;
        int left = 0;

        for(int right = 0; right < N; right++) {
            fruit.put(arr[right], fruit.getOrDefault(arr[right], 0) + 1);

            while (fruit.size() > 2) {
                fruit.put(arr[left], fruit.get(arr[left]) - 1);

                if(fruit.get(arr[left]) == 0) {
                    fruit.remove(arr[left]);
                }

                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}