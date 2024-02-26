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
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer>[] list = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s);
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[N+1];
		
		q.add(1);
		visit[1] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			cnt++;
			
			for(int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				
				if(!visit[next]) {
					visit[next] = true;
					q.offer(next);
				}
 			}
		}
		System.out.println(cnt-1);
	}
}