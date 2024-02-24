import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 가수의 수
        int M = Integer.parseInt(st.nextToken()); // 보조 PD의 수

        List<Integer>[] list = new ArrayList[N+1];
        
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        int[] singer = new int[N+1];
        boolean[] visit = new boolean[N+1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int T =  Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            for(int j = 1; j < T; j++){
                int e = Integer.parseInt(st.nextToken());
                if(!list[s].contains(e)){
                    list[s].add(e);
                    singer[e]++;
                }
                s = e;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0;

        for(int i = 1; i <= N; i++){
            if(singer[i] == 0){
                q.offer(i);
                cnt++;
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            visit[now] = true;
            sb.append(now).append("\n");

            for(int i = 1; i <= N; i++){
                if(!visit[i] && list[now].contains(i)){
                    singer[i]--;

                    if(singer[i] == 0){
                        q.offer(i);
                        cnt++;
                    }
                }
            }
        }

        if(cnt != N){
            System.out.println(0);
        }
        else{
            System.out.println(sb);
        }
    }
}