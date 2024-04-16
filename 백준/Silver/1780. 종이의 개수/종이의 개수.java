import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, arr[][];
    static int one = 0, zero = 0, minus = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        div(0, 0, N);

        sb.append(minus).append("\n")
        .append(zero).append("\n")
        .append(one);

        System.out.println(sb);
    }

    static void div(int start, int end, int size) {

        if(check(start, end, size)) {  
            if (arr[start][end] == -1) {
                minus++;
            }
            else if( arr[start][end] == 0) {
                zero++;
            }
            else {
                one++;
            }

            return;
        }

        int newSize = size / 3;

        div(start, end, newSize);
        div(start, end + newSize, newSize);
        div(start, end + newSize * 2, newSize);

        div(start + newSize, end, newSize);
        div(start + newSize, end + newSize, newSize);
        div(start + newSize, end + newSize * 2, newSize);

        div(start + newSize * 2, end, newSize);
        div(start + newSize * 2, end + newSize, newSize);
        div(start + newSize * 2, end + newSize * 2, newSize);
    }

    static boolean check(int start, int end, int size) {
        int color = arr[start][end];

        for (int i = start; i < start + size; i++) {
			for (int j = end; j < end + size; j++) {
				if (color != arr[i][j]) {
					return false;
				}
			}
		}
        
		return true;
    }
}