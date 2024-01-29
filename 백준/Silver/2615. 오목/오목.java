import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int c = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[21][21];
		
		for(int i = 1; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j < 20; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < 20; i++) {
			for(int j = 1; j < 20; j++) {
				if(arr[i][j] == 1) {
					c = 0;
					if(arr[i-1][j-1] != 1) {
						a(i, j, 1, 0); // 대각선 아래
					}
					if(arr[i][j-1] != 1) {
						b(i, j, 1, 0); // 오른쪽
					}
					if(arr[i+1][j-1] != 1) {
						c(i, j, 1, 0); // 대각선 위
					}
					if(arr[i-1][j] != 1) {
						d(i, j, 1, 0); // 아래
					}
					if(c == 1) {
						System.out.println(i + " " + j);
						System.exit(0);
					}
				}
				if(arr[i][j] == 2) {
					c = 0;
					if(arr[i-1][j-1] != 2) {
						a(i, j, 2, 0); // 대각선 아래
					}
					if(arr[i][j-1] != 2) {
						b(i, j, 2, 0); // 오른쪽
					}
					if(arr[i+1][j-1] != 2) {
						c(i, j, 2, 0); // 대각선 위
					}
					if(arr[i-1][j] != 2) {
						d(i, j, 2, 0); // 아래
					}
					if(c == 1) {
						System.out.println(i + " " + j);
						System.exit(0);
					}
				}
			}
		}
		System.out.println("0");
		br.close();
	}
	
	static void a(int x, int y, int check, int cnt) {
		if(x < 1 || y < 1 || x > 20 || y > 20 || arr[x][y] != check) {
			if(cnt == 5) {
				c = 1;
				System.out.println(check);
			}
			return;
		}
		
		a(x+1, y+1, check, cnt+1);
	}
	
	static void b(int x, int y, int check, int cnt) {
		if(x < 1 || y < 1 || x > 20 || y > 20 || arr[x][y] != check) {
			if(cnt == 5) {
				c = 1;
				System.out.println(check);
			}
			return;
		}
		
		b(x, y+1, check, cnt+1);
	}
	
	static void c(int x, int y, int check, int cnt) {
		if(x < 1 || y < 1 || x > 20 || y > 20 || arr[x][y] != check) {
			if(cnt == 5) {
				c = 1;
				System.out.println(check);
			}
			return;
		}
		
		c(x-1, y+1, check, cnt+1);
	}
	
	static void d(int x, int y, int check, int cnt) {
		if(x < 1 || y < 1 || x > 20 || y > 20 || arr[x][y] != check) {
			if(cnt == 5) {
				c = 1;
				System.out.println(check);
			}
			return;
		}
		
		d(x+1, y, check, cnt+1);
	}
}