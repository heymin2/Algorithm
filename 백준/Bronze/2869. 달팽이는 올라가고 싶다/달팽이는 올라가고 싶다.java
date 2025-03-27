import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long V = Long.parseLong(st.nextToken());

        long day = A - B;
        long goal = V -B;

        if(goal % day != 0) {
            System.out.println(goal / day + 1);
        } 
        else {
            System.out.println(goal / day);
        }
    }
}