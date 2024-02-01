import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int S, P, result = 0;
    static int[] str, check;
    static char[] part;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        check = new int[4];
        part = new char[P];

        String DNA = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        str = new int[4];

        for (int i = 0; i < P; i++) {
            if (DNA.charAt(i) == 'A')
                str[0]++;
            else if (DNA.charAt(i) == 'C')
                str[1]++;
            else if (DNA.charAt(i) == 'G')
                str[2]++;
            else
                str[3]++;
        }

        if (check_num(str, check)) {
            result++;
        }

        int idx = 0;

        for (int i = P; i < S; i++) {
            if (DNA.charAt(idx) == 'A')
                str[0]--;
            else if (DNA.charAt(idx) == 'C')
                str[1]--;
            else if (DNA.charAt(idx) == 'G')
                str[2]--;
            else
                str[3]--;
            idx++;

            if (DNA.charAt(i % S) == 'A')
                str[0]++;
            else if (DNA.charAt(i % S) == 'C')
                str[1]++;
            else if (DNA.charAt(i % S) == 'G')
                str[2]++;
            else
                str[3]++;

            if (check_num(str, check)) {
                result++;
            }
        }

        System.out.println(result);
    }

    static boolean check_num(int[] str, int[] check) {
        for (int i = 0; i < 4; i++) {
            if (check[i] > str[i]) {
                return false;
            }
        }
        return true;
    }
}