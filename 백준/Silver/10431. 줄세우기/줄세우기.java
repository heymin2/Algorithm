import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int P = Integer.parseInt(br.readLine());

        for(int i = 1; i <= P; i++) {
            st = new StringTokenizer(br.readLine());
            List<Integer> list = new ArrayList<>();
            Integer.parseInt(st.nextToken());
            int student = Integer.parseInt(st.nextToken());
            list.add(student);
            int result = 0;
            for(int j = 0; j < 19; j++) {
                boolean flag = false;
                student = Integer.parseInt(st.nextToken());

                for(int k = list.size()-1; k >=0; k--) {
                    if(list.get(k) < student) {
                        list.add(student);
                        flag = true;
                        break;
                    }
                    result++;
                }
                if(!flag) {
                    list.add(student);
                }

                list.sort(null);
            }
            sb.append(i).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
}