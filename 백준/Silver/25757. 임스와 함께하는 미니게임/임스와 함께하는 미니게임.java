import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        String M = st.nextToken();
        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int cnt = 0;

        if(M.equals("Y")) cnt = 2;
        else if(M.equals("F")) cnt = 3;
        else if(M.equals("O")) cnt = 4;

        System.out.println(set.size() / (cnt-1));
    }
}