import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        int [] p = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }

        int N = 1;
        int low = 1;
        int high = 1;

        for(int i = 1; i < M; i++){
            if(p[i-1] > p[i]){
                low++;
                high = 1;
                N = Math.max(N, low);
            }
            else if(p[i-1] < p[i]){
                high++;
                low = 1;
                N = Math.max(N, high);
            }
        }

        System.out.println(N);
    }
}
