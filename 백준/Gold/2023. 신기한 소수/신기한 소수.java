import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        re(0, 0);
        
        System.out.println(sb);
    }

    static void re(int cnt, int num){
        if(cnt == N){
            sb.append(num).append("\n");
            return;
        }
        for(int i = 1; i <= 9; i++){
            int now = 10 * num + i;
            if(isPrime(now)){
                re(cnt+1, now);
            }
        }
    }

    static boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        else{
            for(int i = 2; i*i <= num; i++){
                if(num % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}