import java.io.*;
import java.util.*;

public class Main {
    static char[][] black = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};

    static char[][] white = {{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                            {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                            {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        int result = 999999;

        for(int i = 0; i <= N - 8; i++) {
            int bcnt = 0, wcnt = 0;
            for(int j = 0; j <= M - 8; j++) {
                bcnt = 0; wcnt = 0;
                for(int a = 0; a < 8; a++) {
                    for(int b = 0; b < 8; b++) {
                        if(arr[i+a][j+b] != black[a][b]) bcnt++;
                        if(arr[i+a][j+b] != white[a][b]) wcnt++;
                    }
                }

                result = Math.min(result, Math.min(wcnt, bcnt));
            }
        }
        System.out.println(result);
    }
}