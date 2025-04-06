import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        List<Integer> list = new ArrayList<>();
        String[] split = input.split("-");
        for(String s : split) {
            int sum = 0;
            String[] split2 = s.split("\\+");
            for(String sp : split2) {
                sum += Integer.parseInt(sp);
            }
            list.add(sum);
        }

        long result = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            result -= list.get(i);
        }
        System.out.println(result);
    }
}