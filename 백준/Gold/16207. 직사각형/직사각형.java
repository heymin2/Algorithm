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

        list.sort(null);
        int idx = N-1;
        List<Integer> result = new ArrayList<>();
        while(true) {
            if(idx <= 0) break;

            if(list.get(idx).equals(list.get(idx-1))) {
                result.add(list.get(idx));
                idx -= 2;
            }
            else if(list.get(idx) -1 == list.get(idx-1)) {
                result.add(list.get(idx) -1);
                idx -= 2;
            }
            else {
                idx--;
            }
        }

        if(result.size() == 0) System.out.println(0);
        else {
            long value = 0;

            while(result.size() > 1) {
                value += (long) result.get(0) * result.get(1);
                result.remove(0);
                result.remove(0);
            }

            System.out.println(value);
        }
    }
}