import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Character> S = new ArrayList<>();
        String c = br.readLine();
        for(int i = 0; i < N; i++) {
            S.add(c.charAt(i));
        }

        // 맨 뒷글자 자음 제외
        for(int i = S.size()-1; i >= 0; i--) {
            if(S.get(i) == 'A' || S.get(i) == 'E' || S.get(i) == 'I' || S.get(i) == 'O' || S.get(i) == 'U') {
                S.remove(i);
            }
            else {
                break;
            }
        }

        for(int i = S.size()-2; i >= 0; i--) {
            if(S.get(i) != 'A') {
                S.remove(i);
            }
            else {
                break;
            }
        }

        for(int i = S.size()-3; i >= 0; i--) {
            if(S.get(i) != 'A') {
                S.remove(i);
            }
            else {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();

        if(S.size() >= M) {
            sb.append("YES\n");
            for(int i = S.size()-M; i < S.size(); i++) {
                sb.append(S.get(i));
            }
        }
        else{
            sb.append("NO");
        }
        System.out.println(sb);
    }
}