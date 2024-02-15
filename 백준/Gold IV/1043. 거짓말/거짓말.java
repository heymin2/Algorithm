import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> true_member = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();

        boolean[] visit = new boolean[N+1];

        for(int i = 0; i < K; i++){
            int m = Integer.parseInt(st.nextToken());
            true_member.offer(m);
            visit[m] = true;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            int[] party = new int[T];

            for(int j = 0; j < T; j++){
                party[j] = Integer.parseInt(st.nextToken());
            }

            list.add(party);
        }

        while (!true_member.isEmpty()) {
            int num = true_member.poll();

            if(M == 0){
                break;
            }

            for(int i = list.size()-1; i >= 0; i--){
                for(int j = 0; j < list.get(i).length; j++){
                    if(list.get(i)[j] == num){
                        for(int k = 0; k < list.get(i).length; k++){
                            int current = list.get(i)[k];
                            if(!visit[current]){
                                visit[current] = true;
                                true_member.offer(current);
                             }
                        }
                        M--;
                        list.remove(i);
                        break;
                    }
                } 
            }
        }
        System.out.println(M);
    }
}