import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        while(K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점
            int E = Integer.parseInt(st.nextToken()); // 간선
            list = new ArrayList<>();

            for(int i = 0; i <= V; i++) {
                list.add(new ArrayList<>());
            }

            for(int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken()); 
                int v = Integer.parseInt(st.nextToken()); 

                list.get(u).add(v);
                list.get(v).add(u);
            }

            boolean flag = false;
            arr = new int[V+1];
            for(int i = 1; i <= V; i++) {
                if(arr[i] == 0) {
                    flag = bfs(i);
                }
                if(!flag) break;
            }

            if(flag) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }

    static boolean bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        arr[start] = 1;

        while(!q.isEmpty()) {
            int now = q.poll();

            for(int next : list.get(now)) {
                if(arr[now] == arr[next]) return false;
                if(arr[next] == 0) {
                    arr[next] = arr[now] * -1;
                    q.add(next);
                }
            }
        }

        return true;
    }
}