import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][], turn[], max = 0;
    static boolean[] visit;

    public static void main(String[] args) throws IOException{
        // 1. 타자 순서 뽑기 - 1번 타자는 4번
        // 2. 이닝별로 아웃 당하기 전까지 점수 체크
        // 3. 최대 점수 비교

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][9];
       

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[9];
        turn = new int[9];
        permutation(0);

        System.out.println(max);

    }

    static void permutation(int cnt){
        if(cnt == 9){
            if(turn[3] == 0){
                max = Math.max(max, baseball());
            }
            return;
        }

        for(int i = 0; i < 9; i++){
            if(!visit[i]){
                visit[i] = true;
                turn[cnt] = i;
                permutation(cnt+1);
                visit[i] = false;
            }
        }
    }

    static int baseball(){
        int sum = 0;
        int order = 0;

        for(int i = 0; i < N; i++){
            int out = 0;
            boolean[] base = new boolean[4];

            while(out != 3){
                if(order == 9){
                    order = 0;
                }

                if(arr[i][turn[order]] == 0){ // 아웃
                    out++;
                }
                else if(arr[i][turn[order]] == 1){ // 안타
                    for(int k = 3; k>=1; k--){
                        if(base[k]){
                            if(k == 3){ // 3루 -> 홈 (1점)
                                sum++;
                                base[k] = false;
                                continue;
                            }
    
                            base[k] = false; // (1루 -> 2루, 2루 -> 3루)
                            base[k+1] = true;
                        }
                    }
                    base[1] = true; // 1루
                } 
                else if(arr[i][turn[order]] == 2){ // 이루타
                    for(int k = 3; k>=1; k--){
                        if(base[k]){
                            if(k == 3 || k == 2){ // 2루, 3루 -> 홈 (1점)
                                sum++;
                                base[k] = false;
                                continue;
                            }

                            base[k] = false; // (1루 -> 3루)
                            base[k+2] = true;
                        }
                    }
                    base[2] = true; // 1루
                }
                else if(arr[i][turn[order]] == 3){ // 삼루타
                    for(int k = 3; k>=1; k--){
                        if(base[k]){
                            sum++;
                            base[k] = false;
                        }
                    }
                    base[3] = true;
                }
                else if(arr[i][turn[order]] == 4){ // 홈런
                    for(int k = 3; k>=1; k--){
                        if(base[k]){
                            sum++;
                            base[k] = false;
                        }
                    }
                    sum++;
                }
                order++;
            }
        }
        return sum;
    }
}