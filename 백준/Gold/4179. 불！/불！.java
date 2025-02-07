import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Queue<Node> q = new ArrayDeque<>();
        boolean[][] visit = new boolean[R][C];
        Queue<int[]> fire = new ArrayDeque<>();
        boolean[][] fireVisited = new boolean[R][C];

        char[][] mirro = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                mirro[i][j] = input.charAt(j);

                if (mirro[i][j] == 'J') {
                    q.add(new Node(i, j, 0));
                    visit[i][j] = true; // 지훈 시작 위치 방문 처리
                }
                if (mirro[i][j] == 'F') {
                    fire.add(new int[]{i, j});
                    fireVisited[i][j] = true; // 불 시작 위치 방문 처리
                }
            }
        }

        while (!q.isEmpty()) {
            // 1. 불 확산 처리
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                int[] fireball = fire.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = fireball[0] + dx[k];
                    int ny = fireball[1] + dy[k];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (mirro[nx][ny] == '#' || fireVisited[nx][ny]) continue;

                    fireVisited[nx][ny] = true;
                    mirro[nx][ny] = 'F'; // 불 확산
                    fire.add(new int[]{nx, ny});
                }
            }

            // 2. 지훈 이동 처리
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node now = q.poll();

                // 지훈이 탈출 가능한 경우
                if (now.x == 0 || now.y == 0 || now.x == R - 1 || now.y == C - 1) {
                    System.out.println(now.cnt + 1); // 결과 출력 (1-based count)
                    return;
                }

                for (int k = 0; k < 4; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if (mirro[nx][ny] == '#' || mirro[nx][ny] == 'F' || visit[nx][ny]) continue;

                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny, now.cnt + 1));
                }
            }
        }

        // 지훈이 탈출하지 못한 경우
        System.out.println("IMPOSSIBLE");
    }

    static class Node {
        int x, y, cnt;

        Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
