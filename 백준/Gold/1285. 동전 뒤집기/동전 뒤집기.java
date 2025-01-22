import java.io.*;

public class Main {
    static int N;
    static char[][] coins;
    static char[][] tempCoins;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coins = new char[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                coins[i][j] = input.charAt(j);
            }
        }

        // 재귀적으로 모든 행 뒤집기 조합 탐색
        dfs(0);

        // 결과 출력
        System.out.println(min);
    }

    // 모든 행 뒤집기 조합 탐색
    static void dfs(int row) {
        if (row == N) {
            min = Math.min(min, countTail());
            return;
        }

        dfs(row + 1);

        flipRow(row);
        dfs(row + 1);
        flipRow(row);
    }

    // 현재 상태에서 열 기준으로 뒷면(T) 개수 계산
    static int countTail() {
        int totalTail = 0;

        for (int col = 0; col < N; col++) {
            int tailCount = 0;

            for (int row = 0; row < N; row++) {
                if (coins[row][col] == 'T') {
                    tailCount++;
                }
            }

            // 현재 열의 T 개수와 H 개수 중 최소값을 선택
            totalTail += Math.min(tailCount, N - tailCount);
        }

        return totalTail;
    }

    // 특정 행을 뒤집는 함수
    static void flipRow(int row) {
        for (int col = 0; col < N; col++) {
            coins[row][col] = (coins[row][col] == 'H') ? 'T' : 'H';
        }
    }
}