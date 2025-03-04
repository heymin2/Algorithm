import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] inputs = new String[N];
        for(int t = 0; t < N; t++) {
            inputs[t] = br.readLine(); 
        }

        Arrays.sort(inputs, (o1, o2) -> o2.length() - o1.length());
        List<String> result = new ArrayList<>();
        for(String input : inputs) {
            if(result.size() == 0) {
                result.add(input);
                continue;
            }

            boolean check = false;
            for(String now : result) {
                if(now.indexOf(input) == 0) {
                    check = true;
                    break;
                }
            }

            if(!check) {
                result.add(input);
            }
        }

        System.out.println(result.size());
    }
}