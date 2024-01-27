import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long N = Integer.parseInt(st.nextToken());
        long D = Integer.parseInt(st.nextToken());
        long a, b, c = 0;

        a = (X + Y) * N;

        if((X+Y) % 2 == 0){
            b = Math.max(X, Y) * D;
        }
        else{
            b = (Math.max(X, Y)-1) * D + N;
        }

        c = Math.min(X, Y)*D + (Math.max(X, Y) - Math.min(X, Y)) * N;

        long min = Math.min(a, Math.min(b, c));

        System.out.println(min);
    }
}