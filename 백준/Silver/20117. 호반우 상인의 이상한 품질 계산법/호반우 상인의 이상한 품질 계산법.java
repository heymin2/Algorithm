import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        int idx = 0;
        int result = 0;
        list.sort(null);

        while(!list.isEmpty()) {
            if(list.size() > 1) {
                idx = list.size()-1;
                result += list.get(idx) * 2;
                list.remove(idx);
                list.remove(0);
            }
            else if(list.size() == 1) {
                result += list.get(0);
                list.remove(0);
            }
        }
     
        System.out.println(result);
    }
}