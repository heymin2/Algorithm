import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int m, n, countOne, count;
	static Queue<int[]> queue;
	static int size, tempSize, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		queue = new LinkedList<int[]>();

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					queue.offer(new int[] { i, j });
				} else if (map[i][j] == 0) {
					count++;
				}
			}
		}

		bfs();
	}

	static void bfs() {
		int days = 0;
		while (count > 0 && !queue.isEmpty()) {

			for (int i = queue.size(); i > 0; i--) {
				int[] cur = queue.poll();

				for (int d = 0; d < 4; d++) {
					int ni = cur[0] + delta[d][0];
					int nj = cur[1] + delta[d][1];

					if (ni >= 0 && ni < n && nj >= 0 && nj < m && map[ni][nj] == 0) {
						map[ni][nj] = 1;
						count--;
						queue.offer(new int[] { ni, nj });
					}
				}
			}
			days += 1;

		}
		System.out.println(count==0? days: -1);
	}

}