import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static String N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
       
        if (N.length() == 1 || N.equals("10")) {
            System.out.println(N);
        }
        else {
            check("20", 11);
        }
    }
    
    static void check(String str, int cnt) {
       if (cnt == Integer.parseInt(N)) {
            System.out.println(str);
            System.exit(0);
        }

        if (str.equals("9876543210")) {
            System.out.println(-1);
            System.exit(0);
        } 

        String check = Integer.toString(Integer.parseInt(str) + 1);
        
        while(!IsDown(check)) {
            String c = "";

            for (int i = 0; i < check.length() - 1; i++) {
                int a = check.charAt(i) - '0';
                int b = check.charAt(i+1) - '0';

                if (a <= b) {
                    for (int k = 0; k < check.length(); k++) {
                        if (k < i) {
                            c += check.charAt(k) - '0';
                        } else if (k == i) {
                            c += check.charAt(k) - '0' + 1;
                        } else {
                            c += 0;
                        }
                    }

                    check = c;
                    break;
                }
            }
        }
        
        check(check, cnt+1);
    }

    static boolean IsDown(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            int a = str.charAt(i) - '0';
            int b = str.charAt(i + 1) - '0';
            if (a <= b) {
                return false;
            }
        }

        return true;
    }
}