import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, L, arr[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for(int i = 0; i < N; i++){
            if(check(i)){
                result++;
            }
            if(check2(i)){
                result++;
            }
        }
        System.out.println(result);
    }

    static boolean check(int k){
        boolean[] flag = new boolean[N];
        
        for(int i = 0; i < N-1; i++){
            int now = arr[k][i];
            int next = arr[k][i+1];

            if(now == next) continue; // 높이가 같은 경우 넘어감

            if(Math.abs(now - next) >= 2){ // 높이가 1 이상 차이나면 안됨
                return false;
            }

            if(now > next){ // 현재가 더 높음
                for(int j = 0; j < L; j++){
                    if(i+1+j >= N || flag[i+1+j]) return false;
                    if(arr[k][i] != arr[k][i+1+j] + 1) return false;
                    flag[i+1+j] = true;
                }
            }
            else{ // 다음이 더 높음
                for(int j = 0; j < L; j++){
                    if(i - j < 0 || flag[i-j]) return false;
                    if(arr[k][i] != arr[k][i-j]) return false;
                    flag[i-j] = true;
                }
            }
        }
        return true;
    }

    static boolean check2(int k){
        boolean[] flag = new boolean[N];
        
        for(int i = 0; i < N-1; i++){
            int now = arr[i][k];
            int next = arr[i+1][k];

            if(now == next) continue; // 높이가 같은 경우 넘어감

            if(Math.abs(now - next) >= 2){ // 높이가 1 이상 차이나면 안됨
                return false;
            }

            if(now > next){ // 현재가 더 높음
                for(int j = 0; j < L; j++){
                    if(i+1+j >= N || flag[i+1+j]) return false;
                    if(arr[i][k] != arr[i+1+j][k] + 1) return false;
                    flag[i+1+j] = true;
                }
            }
            else{ // 다음이 더 높음
                for(int j = 0; j < L; j++){
                    if(i - j < 0 || flag[i-j]) return false;
                    if(arr[i][k] != arr[i-j][k]) return false;
                    flag[i-j] = true;
                }
            }
        }
        return true;
    }
}