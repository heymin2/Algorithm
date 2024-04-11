import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, arr[], check[];
	static boolean[] visit;
	static StringBuilder sb;

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	
    	arr = new int[N];
    	check = new int[M];
    	visit = new boolean[N];
    	
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	Arrays.sort(arr);
    	
    	re(0,0);
    	System.out.println(sb);
    }
    
    static void re(int cnt, int idx) {
    	if(cnt == M) {
    		for(int i = 0; i < M; i++) {
    			sb.append(check[i]).append(" ");
    		}
    		
    		sb.append("\n");
    		return;
    	}
    	
    	for(int i = idx; i < N; i++) {
    		if(!visit[i]) {
    			visit[i] = true;
    			check[cnt] = arr[i];
        		re(cnt+1, i);
        		visit[i] = false;
    		}
    	}
    }
}