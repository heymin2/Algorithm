import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int arr[]=new int[K]; 
        int cnt = 0;
        
        Queue<Integer>[] queue = new LinkedList[101];
            
        for(int i=1; i<=100; i++) queue[i]=new LinkedList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < K; i++) { // 번호에 순서 넣기
            arr[i] = Integer.parseInt(st.nextToken());
            queue[arr[i]].add(i); 

        }

        List<Integer> list = new ArrayList<>();

        int c = 0;

        for(int i = 0; i < K; i++) {
            if(!list.contains(arr[i])) {
                list.add(arr[i]);
            }
            queue[arr[i]].poll();

            if(list.size() == N) {
                c = i++;
                break;
            }
        }

        for(int i = c; i < K; i++) {
            int num = arr[i];
            queue[num].poll();

            int idx = -1; int max = 0;
            if(list.contains(num)) {
                continue;
            }

            for(int v : list) {
                if(queue[v].isEmpty()) {
                    idx = v;
                    break;
                }

                if(queue[v].peek() > max) {
                    max = queue[v].peek();
                    idx = v;
                }
            }


            for(int j = 0; j < N; j++) {
                if(list.get(j) == idx) {
                    list.remove(j);
                    break;
                }
            }
            list.add(num);
            cnt++;
        }

        System.out.println(cnt);
    }
}