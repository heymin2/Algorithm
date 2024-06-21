import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 팰린드롬: 왼쪽에서 읽어도, 오른쪽에서 읽어도 같은 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken()) - 1;
            int e  = Integer.parseInt(st.nextToken()) -1;

            int num = e-s;
            boolean flag = true;

            if(num % 2 == 0) num = num / 2;
            else num = num / 2 + 1;

            for(int j = 0; j < num; j++) {
                if(arr[s] != arr[e]){
                    sb.append(0).append("\n");
                    flag = false;
                    break;
                }
                s++;
                e--;
            }

            if(flag) {
                sb.append(1).append("\n");
            }
        }

        System.out.println(sb);
    }
}