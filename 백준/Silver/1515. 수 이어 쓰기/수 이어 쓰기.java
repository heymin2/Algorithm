import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int idx = 0;
        int result = 0;

        while(true) {
            result++;

            String value = Integer.toString(result);
            for(int j = 0; j < value.length(); j++) {
                if(value.charAt(j) == num.charAt(idx)) idx++;
                if(idx == num.length()) {
                    System.out.println(result);
                    return;
                }
            }
        }
	}
}