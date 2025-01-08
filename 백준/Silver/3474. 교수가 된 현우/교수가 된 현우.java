import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());


        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            int result = 0;

            for(int k = 5; k <= input; k *= 5) {
                result += input / k;
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}