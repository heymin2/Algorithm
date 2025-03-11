import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int S = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int cnt = 0, result = 0, i = 1;
        while(i < S-1) {
            if(input.charAt(i) == 'O' && input.charAt(i+1) == 'I') {
                cnt++;
                if(cnt == N) {
                    if(input.charAt(i - (cnt*2-1)) == 'I') result++;
                    cnt--;
                }
                i +=2;
            }
            else {
                cnt = 0;
                i++;
            }
        }
       
        System.out.println(result);
    }
}