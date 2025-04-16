import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            if(a.equals("push")) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            else if(a.equals("pop")) {
                if(list.size() == 0) {
                    sb.append("-1\n");
                }
                else {
                    sb.append(list.get(0)).append("\n");
                    list.remove(0);
                }
            }
            else if(a.equals("size")) {
                sb.append(list.size()).append("\n");
            }
            else if(a.equals("empty")) {
                if(list.size() == 0) sb.append("1\n");
                else sb.append("0\n");
            }
            else if( a.equals("front")) {
                if(list.size() == 0) sb.append("-1\n");
                else sb.append(list.get(0)).append("\n");
               
            }
            else if(a.equals("back")) {
                if(list.size() == 0) sb.append("-1\n");
                else sb.append(list.get(list.size()-1)).append("\n");
            }
        }
        System.out.println(sb);
    }
}