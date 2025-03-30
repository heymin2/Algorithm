import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N * 2];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arr[N+i] = arr[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for(int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        if(map.get(c) != null) max = Math.max(max, map.size());
        else max =  Math.max(max, map.size() + 1);

        for(int i = k; i < N * 2; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            map.put(arr[i-k], map.get(arr[i-k]) - 1);

            if(map.get(arr[i-k]) == 0) {
                map.remove(arr[i-k]);
            }

            if(map.get(c) != null) max = Math.max(max, map.size());
            else max =  Math.max(max, map.size() + 1);
        }

        System.out.println(max);
    }
}