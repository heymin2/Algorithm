import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<int[]> twoIdxList = new ArrayList<>();
	static List<int[]> oneIdxList = new ArrayList<>();
	static List<int[]> comb = new ArrayList<>();
	static int N, M, sum, min;
	static int[] arr;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[] selected;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 개수
		arr = new int[M];

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				if (k == 2) {
					twoIdxList.add(new int[] { i, j });
					map[i][j] = 0;
				} else if (k == 1) {
					oneIdxList.add(new int[] { i, j, 0 });
					map[i][j] = 1;
				} else {
					map[i][j] = 0;
				}
			}
		}
//		for (int[] a : oneIdxList) {
//			System.out.println(Arrays.toString(a));
//		}
		selected = new boolean[twoIdxList.size()];
		min = Integer.MAX_VALUE;
		combi(0, 0);// comb에 2인 것 모음 idx 리스트들 저장
		/*
		 * 출력확인 System.out.println("==="); for(int[] co : comb) {
		 * System.out.println(Arrays.toString(co)); } System.out.println("===");
		 * System.out.println(twoIdxList.size());
		 */
		/*
		for (int[] co : comb) {
			sum = 0;

			for (int c : co) {// 경우의 수 하나
				map[twoIdxList.get(c)[0]][twoIdxList.get(c)[1]] = 2;
			}
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			//1인 것마다 bfs
			for (int[] a : oneIdxList) {
				bfs(a);
			}
			//2인 것 원상복구
			for (int c : co) {
				map[twoIdxList.get(c)[0]][twoIdxList.get(c)[1]] = 0;
			}

			if (sum < min)
				min = sum;
		}
		*/

		System.out.println(min);

	}

	static void combi(int start, int depth) {
		if (depth == M) {
			int check = 0;
			for (int[] a : oneIdxList) check += bfs(a);
			if (check < min) min = check;
			return;
		}

		for (int i = start; i < twoIdxList.size(); i++) {
			map[twoIdxList.get(i)[0]][twoIdxList.get(i)[1]] = 2;
			arr[depth] = i;
			combi(i + 1, depth + 1);
			map[twoIdxList.get(i)[0]][twoIdxList.get(i)[1]] = 0;
		}
	}

	static int bfs(int[] a) {// bfs
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		queue.offer(a);
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int dist = cur[2];

			for (int d = 0; d < 4; d++) {
				int ni = cur[0] + di[d];
				int nj = cur[1] + dj[d];

				if (ni >= 0 && ni < N && nj >= 0 && nj < N && !visited[ni][nj]) {
					if (map[ni][nj] == 2) return dist + 1;
					visited[ni][nj] = true;
					queue.offer(new int[] { ni, nj, dist + 1 });
				}
			}
		}
		return 0;
	}
}
