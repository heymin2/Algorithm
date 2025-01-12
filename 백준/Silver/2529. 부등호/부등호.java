import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        StringBuilder sb = new StringBuilder();

        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        int num = 9;
        q.push(num);

        for(int i = 0; i < N; i++) {
            num--;
            if(arr[i] == '>') {
                while(!q.isEmpty()) {
                    sb.append(q.pop());
                }
            }
            q.push(num);
        }

        while(!q.isEmpty()) {
            sb.append(q.poll());
        }

        sb.append("\n");

        num = 0;
        q.push(num);

        for(int i = 0; i < N; i++) {
            num++;
            if(arr[i] == '<') {
                while(!q.isEmpty()) {
                    sb.append(q.pop());
                }
            }
            q.push(num);
        }

        while(!q.isEmpty()) {
            sb.append(q.pop());
        }

        System.out.println(sb);
    }
}