import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[], result = 1000; // 인구수
    static List<Integer>[] list; // 인접 체크
    static boolean[] visit;
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        list = new ArrayList[N+1];
        visit = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());    
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());

            for(int j = 0; j < num; j++){
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        powerSet(1);

        if(result == 1000){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }
    }

    static void powerSet(int cnt){
        if(cnt == N){
            List<Integer> A = new ArrayList<>();
            List<Integer> B = new ArrayList<>();

            for(int i = 1; i <=  N; i++){
                if(visit[i]){
                    A.add(i);
                }
                else{
                    B.add(i);
                }
            }

            if(!A.isEmpty() && !B.isEmpty()){
                if(link(A) && link(B)){
                    int diff = Math.abs(people(A) - people(B));
                    result = Math.min(result, diff);
                }
            }

            return;
        }
        visit[cnt] = true;
        powerSet(cnt+1);
        visit[cnt] = false;
        powerSet(cnt+1);
    }

    static boolean link(List<Integer> l){
        boolean[] visit = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque();
        int cnt = 0;

        q.offer(l.get(0));
        visit[l.get(0)] = true;

        while(!q.isEmpty()){
            int now = q.poll();
            cnt++;

            for(int i = 0; i < list[now].size(); i++){
                int num = list[now].get(i);
                if(!visit[num] && l.contains(num)){
                    q.offer(num);
                    visit[num] = true;
                }
            }
        }

        if(cnt == l.size()){
            return true;
        }
        return false;
    }

    static int people(List<Integer> l){
        int sum = 0;

        for(int i = 0; i < l.size(); i++){
            sum += arr[l.get(i)];
        }

        return sum;
    }
}