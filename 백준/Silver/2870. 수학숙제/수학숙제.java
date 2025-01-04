import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        int N = Integer.parseInt(br.readLine());
        List<String> result = new ArrayList<>();

        for(; N > 0; N--) {
           String input = br.readLine();

           Queue<Integer> q = new ArrayDeque<>();

           for(int i = 0; i < input.length(); i++) {
                int now = input.charAt(i) - '0';

                if(0 <= now && now <= 9) {
                    q.add(now);
                }
                else {
                    String value = "";

                    if(!q.isEmpty()) {
                        while(!q.isEmpty()) {
                            int check = q.poll();

                            if(check == 0 && value == "") {
                                if(q.size() == 0) {
                                    value += check;
                                }
                            }
                            else {
                                value += check;
                            }
                        }
                        
                        result.add(value);
                    }
                }
            }

            String value = "";
            
            if(!q.isEmpty()) {
                while(!q.isEmpty()) {
                    int check = q.poll();

                    if(check == 0 && value == "") {
                        if(q.size() == 0) {
                            value += check;
                        }
                    }
                    else {
                        value += check;
                    }
                }
                
                result.add(value);
            }
        }


        result.sort((a, b) -> new BigInteger(a).compareTo(new BigInteger(b)));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}