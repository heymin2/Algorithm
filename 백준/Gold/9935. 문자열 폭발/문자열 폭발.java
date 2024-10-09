import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        String bom = br.readLine();
        int bomSize = bom.length();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < input.length(); i++) {
            stack.add(input.charAt(i));

            if(stack.size() >= bomSize) {
                boolean flag = true;

                for(int j = 0; j < bomSize; j++) {
                    if(stack.get(stack.size() - bomSize+j) != bom.charAt(j)) {
                        flag = false;
                        break;
                    }
                }

                if(flag) {
                    for(int j = 0; j < bomSize; j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        if(stack.size() == 0) {
            System.out.println("FRULA");
        }
        else {
            for(int i = 0; i < stack.size(); i++) {
                sb.append(stack.get(i));
            }
            System.out.println(sb);
        }
    }
}