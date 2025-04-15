import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[M];
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
       
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }

        int cost = 0;
        for(int i = 0; i < M; i++) {
            int idx = list.indexOf(arr[i]);
            int middle;

            if(list.size() % 2 == 0) {
                middle = list.size() / 2 - 1;
            }
            else {
                middle = list.size() / 2;
            }

            if(idx <= middle) {
                for(int j = 0; j < idx; j++) {
                    int tmp = list.get(0);
                    list.remove(0);
                    list.add(tmp);
                    cost++;
                }
            }
            else {
                for(int j = 0; j < list.size() - idx; j++) {
                    int tmp = list.remove(list.size() - 1);
                    list.add(0, tmp);
                    cost++;
                }
            }
            list.remove(0);
        }
        System.out.println(cost);
    }
}