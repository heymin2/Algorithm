import java.io.*;
import java.util.*;

public class Main {
    static int N, result = Integer.MIN_VALUE;
    static char[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        input = new char[N];
        input = br.readLine().toCharArray();


        solve(2, input[0]-'0');
        System.out.println(result);
    }

    static void solve(int i, int sum) {
        if(i >= N) {
            result = Math.max(result, sum);
            return;
        }

        solve(i+2, calculate(sum, input[i] - '0', input[i-1]));

        if(i + 2 < N) {
            int right = calculate(input[i] - '0', input[i+2] - '0', input[i+1]);
            int left = calculate(sum, right, input[i-1]);
            solve(i+4, left);
        }
    }

    static int calculate(int i, int j, char op) {
        if(op == '+') return i + j;
        else if(op == '-') return i - j;
        else return i * j;
    }
}