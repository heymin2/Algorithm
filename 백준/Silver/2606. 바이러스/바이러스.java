import java.util.*;
import java.io.*;

public class Main {
    static int computerCnt;
    static int connectCnt;
    static int[][] computer;
    static boolean[] check;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        computerCnt = Integer.parseInt(br.readLine());
        connectCnt = Integer.parseInt(br.readLine());
        computer = new int[computerCnt+1][computerCnt+1];
        check = new boolean[computerCnt+1];

        for(int i = 0; i < connectCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            computer[a][b] = computer[b][a] = 1;
        }

        dfs(1);
        System.out.println(result);
    }

    static void dfs(int start) {
        check[start] = true;

        for(int i = 1; i <= computerCnt; i++) {
            if(!check[i] && computer[start][i] == 1) {
                result++;

                dfs(i);
            }
        }   
    }
}