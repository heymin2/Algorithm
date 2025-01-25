import java.io.*;
import java.util.*;

public class Main {
    static int[][] prefix;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());
        int result = 0;

        int[][] arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if(arr[i][j] == 1) result++;
            }
        }

        if(K != 0) {
            result = 0;

            // 누적합 배열 생성
            prefix = new int[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    prefix[i][j] = arr[i - 1][j - 1] 
                                + prefix[i - 1][j] 
                                + prefix[i][j - 1] 
                                - prefix[i - 1][j - 1];
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (arr[r][c] == 1 && isValidCross(r, c, K)) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }

    // 십자가 유효성 검사 함수
    static int getSum(int r1, int c1, int r2, int c2) {
        return prefix[r2 + 1][c2 + 1] 
            - (r1 > 0 ? prefix[r1][c2 + 1] : 0) 
            - (c1 > 0 ? prefix[r2 + 1][c1] : 0) 
            + (r1 > 0 && c1 > 0 ? prefix[r1][c1] : 0);
    }

    static boolean isValidCross(int r, int c, int K) {
        if (r - K < 0 || r + K >= N || c - K < 0 || c + K >= M) return false;

        // 위, 아래, 왼쪽, 오른쪽 방향 검사
        if (getSum(r - K, c, r - 1, c) != K) return false;
        if (getSum(r + 1, c, r + K, c) != K) return false;
        if (getSum(r, c - K, r, c - 1) != K) return false;
        if (getSum(r, c + 1, r, c + K) != K) return false;

        return true;
    }
}