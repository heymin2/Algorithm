import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 리스트에 있는 점수의 개수
        int newScore = Integer.parseInt(st.nextToken()); // 태수의 새로운 점수
        int P = Integer.parseInt(st.nextToken()); // 랭킹에 올라갈 수 있는 점수의 개수
        
        List<Integer> list = new ArrayList<>();
        if(N == 0) System.out.println(1);
        else {
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            
            list.sort((o1, o2) -> {
                return o2 - o1;
            });

            int min = Math.min(P, N);
    
            if(list.get(N-1) >= newScore) {
                if(N < P) {
                    if(list.get(N-1) == newScore) {
                        int cnt = -1;
                        for(int i = N-1; i >= 0; i--) {
                            if(list.get(i) == newScore) cnt++;
                        }
                        System.out.println(N - cnt);
                    }
                    else if(list.get(N-1) > newScore) System.out.println(N+1);
                }
                else System.out.println(-1);
            }
            else {
                int result = 1;

                for(int i = 0; i < min; i++) {
                    if(list.get(i) <= newScore) {
                        break;
                    }
                    else result++;
                }

                System.out.println(result);
            }
        }
	}
}