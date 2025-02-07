import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
       
        int N = Integer.parseInt(br.readLine()); // 댓글단 학생수

        int[] seat = new int[1_000_002];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            seat[S]++;
            seat[E+1]--;
        }


        int[] sum = new int[1_000_002];
        sum[0] = seat[0];
        for(int i = 1; i < 1_000_001; i++) {
            sum[i] = seat[i] + sum[i-1];
        }

        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine()); // 특정 시각수
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++) {
            int time = Integer.parseInt(st.nextToken()); // 궁금한 시간
            
            sb.append(sum[time]).append("\n");
        }
        System.out.println(sb);
    }
}