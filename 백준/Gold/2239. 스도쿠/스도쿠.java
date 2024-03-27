import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board;
    static int N = 9;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        play();
    }

    static void play() {
        int[] idx = findZero();

        if(idx[0] == -1){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }

            System.out.println(sb);
            System.exit(0);
        }
        else{
            for(int i = 1; i <= N; i++) {
                if(isValid(idx, i)) {
                    board[idx[0]][idx[1]] = i;
                    play();
                    board[idx[0]][idx[1]] = 0;
                }
            }   
        }

    }

    static boolean isValid(int[] idx, int num) {
        int x = idx[0];
        int y = idx[1];

        for(int i = 0; i < N; i++) {
            if(board[x][i] == num || board[i][y] == num) return false;
        }

        int sx = (x/3) * 3;
        int sy = (y/3) * 3;

        for(int i = sx; i < sx+3; i++) {
            for(int j = sy; j < sy+3; j++) {
                if(board[i][j] == num) return false;
            }
        }

        return true;
    }

    static int[] findZero() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(board[i][j] == 0) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}