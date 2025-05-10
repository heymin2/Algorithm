import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        int max = Math.min(M, N);
        if(max == 1) System.out.println(1);
        else {
            while(max != 0) {
                for(int i = 0; i <= N - max; i++) {
                    for(int j = 0; j <= M - max; j++) {
                        if(arr[i][j] == arr[i][j+max-1] &&
                        arr[i][j+max-1] == arr[i+max-1][j] && 
                        arr[i+max-1][j] == arr[i+max-1][j+max-1]) {
                            System.out.println(max * max);
                            return;
                        }
                    }
                }
    
                max--;
            }
        }
    }
}