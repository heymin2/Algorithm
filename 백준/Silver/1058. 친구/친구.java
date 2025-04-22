import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            int count = 0;

            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (map[i][j] == 'Y') {
                    visited[j] = true;
                    count++;
                } else {
                    for (int k = 0; k < N; k++) {
                        if (map[i][k] == 'Y' && map[k][j] == 'Y') {
                            if (!visited[j]) {
                                visited[j] = true;
                                count++;
                            }
                        }
                    }
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
