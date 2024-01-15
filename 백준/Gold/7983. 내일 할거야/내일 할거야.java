import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] HW = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            HW[i][0] = Integer.parseInt(st.nextToken());
            HW[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(HW, (o1, o2) -> o2[1] - o1[1]);

        int cnt = HW[0][1] - HW[0][0];

        for(int i = 1; i < n; i++){
            int d = HW[i][1];
            int t = HW[i][0];
            if(cnt >= d){
                cnt = d - t;
            }
            else{
                cnt -= t;
            }
        }
        System.out.println(cnt);
    }
}
