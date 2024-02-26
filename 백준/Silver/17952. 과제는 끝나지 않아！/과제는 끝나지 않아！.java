import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> s = new Stack<>();
		int sum = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int K = Integer.parseInt(st.nextToken());
			if(K == 1) {
				int score = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				s.add(new int[] {score, time-1});
			}
			else {
				if(s.size() != 0) {
					s.set(s.size()-1, new int[] {s.peek()[0], s.peek()[1]-1});
				}
				else {
					continue;
				}
			}
			
			if(s.peek()[1] == 0) {
				sum += s.peek()[0];
				s.pop();
			}
		}
		
		System.out.println(sum);
	}
}