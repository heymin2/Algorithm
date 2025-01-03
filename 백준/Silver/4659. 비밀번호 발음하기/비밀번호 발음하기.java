import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();

            if(input.equals("end")) break;

            boolean aeiou = false; // 1번 조건
            boolean check2 = true;
            boolean check3 = true;

            int cnt = 0; // 연속 모음, 연속 자음 체크
            int type = 0;

            for(int i = 0; i < input.length(); i++) {
                char now = input.charAt(i);

                // 조건1
                if(now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') {
                    aeiou = true;

                    if(type == 0) {
                        type = 1;
                        cnt = 1;
                    }
                    else {
                        cnt++;
                    }
                }
                else {
                    if(type == 1) {
                        type = 0;
                        cnt = 1;
                    }
                    else {
                        cnt++;
                    }
                }

                // 조건2
                if(cnt >= 3) check2 = false;
                
                // 조건3
                if(i != input.length() -1) {
                    char next = input.charAt(i+1);

                    if(next == now) check3 = false;
                    if((now == 'e' && next == 'e') || (now == 'o' && next == 'o')) {
                        check3 = true;
                    }
                }
            }

            if(aeiou && check2 && check3) sb.append("<").append(input).append("> is acceptable.").append("\n");
            else sb.append("<").append(input).append("> is not acceptable.").append("\n");
        }

        System.out.println(sb);
    }
}