import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Number> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(new Number(br.readLine()));
        }

        list.sort(null);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(list.get(i).value).append("\n");
        }
        System.out.println(sb);
    }
}

class Number implements Comparable<Number> {
    String value;

    public Number(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(Number o) {
        if(value.length() == o.value.length()) {
            int a = 0;
            int b = 0;
            for(int i = 0; i < value.length(); i++) {
                if(value.charAt(i) - '0' < 10) {
                    a += value.charAt(i) - '0';
                }
                if(o.value.charAt(i) - '0' < 10) {
                    b += o.value.charAt(i) - '0';
                }
            }

            if(a == b) {
                for(int i = 0; i < value.length(); i++) {
                    if(value.charAt(i) == o.value.charAt(i)) continue;
                    else return value.charAt(i) - o.value.charAt(i);
                }
            }
            return a - b;
        }
        return value.length() - o.value.length();
    }
}