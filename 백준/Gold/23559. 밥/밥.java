import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long X = Integer.parseInt(st.nextToken());
        
        int[][] menu = new int[N][2];

        int result = 0;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            menu[i][0] = Integer.parseInt(st.nextToken());
            menu[i][1] = Integer.parseInt(st.nextToken());

            result += menu[i][1];
            X -= 1000;
        }

        Arrays.sort(menu, Comparator.comparingInt((int[] arr) -> arr[0] - arr[1]).reversed());

        for(int i = 0; i < N; i++){
            if(X >= 4000 && menu[i][0] > menu[i][1]) {
                result += menu[i][0] - menu[i][1];
                X -= 4000;
            }
        }

        System.out.println(result);
    }
}
