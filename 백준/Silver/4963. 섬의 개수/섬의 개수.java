import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count, w, h;
	static int[][] map;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1},
			{-1, 1}, {1, 1}, {1, -1}, {-1, -1}}; //상하좌우,우상,우하,좌하,좌상
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			count = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken()); //열개수
			h = Integer.parseInt(st.nextToken()); //행개수

			if (h == 0)
				break;
			
			map = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						count++;
						dfs(i, j);
					}
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int i, int j) {
		map[i][j] = 2;
		
		for (int d = 0; d < delta.length; d++) {
			int ni = i + delta[d][0];
			int nj = j + delta[d][1];
			
			if (ni >= 0 && ni < h && nj >= 0 && nj < w && map[ni][nj] == 1) {
				dfs(ni, nj);
			}
		}
	}
}
