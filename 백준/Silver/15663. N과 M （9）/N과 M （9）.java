import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, arr[], result[];
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        re(0);

        System.out.println(sb);
    }

    static void re(int cnt){
        if(cnt == M){
            for(int i = 0; i<M; i++){
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
        }

        else{
            int before = 0;
            for(int i = 0; i<N; i++){
                if(visit[i])
                    continue;

                if(before != arr[i]){
                    visit[i] = true;
                    result[cnt] = arr[i];
                    before = arr[i];
                    re(cnt+1);
                    visit[i] = false;
                }
            }
        }
    }
}