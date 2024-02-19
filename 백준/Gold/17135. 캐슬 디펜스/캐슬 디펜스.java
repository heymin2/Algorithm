import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, D, map[][], arr[], new_map[][];
    static List<int[]> list;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 행의 수
        M = Integer.parseInt(st.nextToken()); // 열의 수
        D = Integer.parseInt(st.nextToken()); // 궁수의 공격 거리 제한

        map = new int[N][M]; // 격자판

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arr = new int[3];

        combination(0, 0);
        System.out.println(result);

    }

    static void combination(int start, int cnt) { // 조합
        if (cnt == 3) {
            result = Math.max(result, attack());
            return;
        }
    
        for (int i = start; i < M; i++) {
            arr[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }

    static int attack() {
        int check = 0;
        new_map = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                new_map[i][j] = map[i][j];
            }
        }
        for (int k = 0; k < N; k++) { // 적 이동 N번
            list = new ArrayList<>();
            for (int cnt = 0; cnt < 3; cnt++) { // 궁수 세명 공격
                double min = 255;
                int x = -1, y = 0;
                for (int i = N-1; i >= k; i--) { // x 좌표
                    for (int j = 0; j < M; j++) { // y 좌표 - 왼쪽부터
                        if (new_map[i][j] == 1) {
                            int d = Math.abs(N - i) + Math.abs(arr[cnt] - j); // 거리
                            // System.out.println(i + " " + j);
                            if (d <= D && min > d) {
                                min = d;
                                x = i;
                                y = j;
                            }
                            else if(min == d){
                                if(y > j){
                                    x = i; 
                                    y = j;
                                }
                            }
                        }
                    }
                }
                if(x != -1 && y != -1){
                    list.add(new int[] { x, y });
                }
            }
            check += new_visit();

            // 궁수의 위치를 아래로 이동시키기
            for (int i = N - 1; i >= 1; i--) {
                for (int j = 0; j < M; j++) {
                    new_map[i][j] = new_map[i - 1][j];
                }
            }
        }

        return check;
    }

    static int new_visit() {
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];

            if (new_map[x][y] == 1) {
                new_map[x][y] = 0;
                cnt++;
            }
        }
        return cnt;
    }
}