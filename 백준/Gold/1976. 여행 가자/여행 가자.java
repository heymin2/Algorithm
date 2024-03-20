import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 도시 수
        M = Integer.parseInt(br.readLine());

        arr = new int[N + 1];

        for(int i = 1; i <= N; i++){
            arr[i] = i;
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++){
                int x = Integer.parseInt(st.nextToken());

                if(x == 1){
                    union(i, j);
                }
            }   
        }

        st = new StringTokenizer(br.readLine());
        String result = "YES";

        int prev = find(Integer.parseInt(st.nextToken()));

        for (int j = 1; j < M; j++) {
            int now = Integer.parseInt(st.nextToken());

            if(prev != find(now)){
                result = "NO";
                break;
            }
        }

        System.out.println(result);
    }
    
    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return;

        if(x < y) arr[y] = x;
        else arr[x] = y;
    }
    
    static int find(int x) {
        if (x == arr[x])
            return x;
        
        return arr[x] = find(arr[x]);
    }
}