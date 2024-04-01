import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
    static long N, R;
    static long p = 1000000007;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        
        N = Long.parseLong(st.nextToken());
        R = Long.parseLong(st.nextToken());

        long a = 1;
        long b = 1;
 
            
        long t = Math.min(R, N - R);
 
         for (int i = 0; i < t; i++) {
            a = a * (N - i) % p;
            b = b * (t - i) % p;
        }
        
        System.out.println((a % p * power(b, p - 2) % p) % p);
    }
 
    static long power(long x, long y) {
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if (y % 2 == 1)
                res = (res * x) % p;
            y = y >> 1;
            x = x * x % p;
        }
        return res;
    }
}