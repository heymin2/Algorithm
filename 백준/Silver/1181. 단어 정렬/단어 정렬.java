import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        List<String> list2 = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < list.size(); i++) {
            if(!list2.contains(list.get(i))) {
                list2.add(list.get(i));
                sb.append(list.get(i)).append("\n");
            }
        }

        System.out.println(sb);
    }
}