import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//dfs 인접리스트
public class Main {
	static List<Integer>[] list;
	static boolean[] visited;
	static int[] dist;
	static int answer = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 사람 수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int tries = Integer.parseInt(br.readLine());

		list = new ArrayList[n+1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<Integer>();
		}
//		System.out.println(a + ": " + b + " : " + tries);

		for (int tc = 0; tc < tries; tc++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			list[from].add(to);
			list[to].add(from);

		}

		visited = new boolean[n + 1];
		dfs(a, b, 0);
		System.out.println(answer);
	}
	
	static void dfs(int a, int b, int count) {
		
		if (a == b) {
			answer = count;
			return;
		}
	
		
		visited[a] = true;
		for (int num: list[a]) {
			if (!visited[num]) {
				dfs(num, b, count+1);
			}
		}
	}
}
