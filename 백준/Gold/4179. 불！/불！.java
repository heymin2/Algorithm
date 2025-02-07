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

        char[][] mirro = new char[R][C];
        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for(int j = 0; j < C; j++) {
                mirro[i][j] = input.charAt(j);

                if(mirro[i][j] == 'J') {
                    q.add(new Node(i, j, 0));
                }  
                if(mirro[i][j] == 'F') {
                    fire.add(new int[]{i, j});
                }  
            }
        }

        while(!q.isEmpty()) {
            int size = fire.size();
            for(int i = 0; i < size; i++) {
                int[] fireball = fire.poll();
                for(int k = 0; k < 4; k++) {
                    int nx = fireball[0] + dx[k];
                    int ny = fireball[1] + dy[k];

                    if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if(mirro[nx][ny] == '#' || mirro[nx][ny] == 'F') continue;
                    
                    mirro[nx][ny] = 'F';
                    fire.add(new int[]{nx, ny});
                }
            }

            size = q.size();
            for(int i = 0; i < size; i++) {
                Node now = q.poll();

                if(now.x == 0 || now.y == 0 || now.x == R-1 || now.y == C-1) {
                    System.out.println(now.cnt+1);
                    return;
                }

                for(int k = 0; k < 4; k++) {
                    int nx = now.x + dx[k];
                    int ny = now.y + dy[k];

                    if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                    if(mirro[nx][ny] == '#' || mirro[nx][ny] == 'F') continue;
                    if(visit[nx][ny]) continue;

                    visit[nx][ny] = true;
                    q.add(new Node(nx, ny, now.cnt+1));
                }
            }
        }
        
        System.out.println("IMPOSSIBLE");
    }
}

class Node {
    int x, y, cnt;

    Node(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}