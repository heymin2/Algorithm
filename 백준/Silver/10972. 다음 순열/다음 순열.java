import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){

            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        if(!re()){
           sb.append(-1);
        }
        else{
            for(int i = 0; i < N; i++){
                sb.append(arr[i]).append(" ");
            }
        }

        System.out.println(sb);
    }

    static boolean re(){
        for(int i = N-1; i > 0; i--){
            if(arr[i-1] < arr[i]){
                for(int j = N-1; j >= i; j--){
                    if(arr[j] > arr[i-1]){
                        int tmp = arr[j];
                        arr[j] = arr[i-1];
                        arr[i-1] = tmp;
                        int k = N - 1;
                        while (i < k) {
                            tmp = arr[i];
                            arr[i] = arr[k];
                            arr[k] = tmp;
                            i++;
                            k--;
                        }
                        return true;
                    }
                }
            }
            
        }
        return false;
    }
   
}