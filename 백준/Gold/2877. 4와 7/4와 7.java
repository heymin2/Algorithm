import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        while (K > 0) {
            if (K % 2 == 1) sb.append("4");
            else sb.append("7");
            K = (K - 1) / 2;
        }
        
        System.out.println(sb.reverse());
    }
}
