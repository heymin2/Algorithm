import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] dp = new int[2][w+2][h+2]; // 0: 동쪽, 1: 북쪽
        dp[0][2][2] = dp[1][2][2] = 1;

        for(int i = 2; i < w + 2; i++) {
            for(int j = 2; j < h + 2; j++) {
                dp[0][i][j] += (dp[0][i][j-1] + dp[1][i-1][j-1]) % 100_000;
                dp[1][i][j] += (dp[1][i-1][j] + dp[0][i-1][j-1]) % 100_000;
            }
        }

        System.out.print((dp[0][w+1][h+1] + dp[1][w+1][h+1]) % 100_000);
    }
}

/*
 * 남북방향 도로 w개
 * 동서방향 도로 h개 
 * 
 * 상근이 (1,1) -> (w,h)
 * 동, 북쪽으로만 이동 가능
 * 교차로 방향 바꾼 후 다음 블록에서 방향 바꾸기 x
 * 출근 가능한 경우의 수 100000로 나눈 나머지
 */