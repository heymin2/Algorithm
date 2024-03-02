import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution
{
    static int N, W, H, arr[][], per[], result;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <= T; test++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            arr = new int[H][W];
            per = new int[N];

            for(int i = 0; i < H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            result = Integer.MAX_VALUE;
            p(0);
            sb.append("#").append(test).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    static void p(int cnt){
        if(cnt == N){
            result = Math.min(getWall(), result);
            return;
        }

        for(int i = 0; i < W; i++){
            per[cnt] = i;
            p(cnt+1);
        }
    }

    static int getWall(){
        int[][] new_arr = new int[H][W];

        // 배열 복사
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                new_arr[i][j] = arr[i][j];
            }
        }

        // 벽 N번 부수기
        for(int i = 0; i < N; i++){ 
            Queue<Node> q = new ArrayDeque<>();

            for(int j = 0; j < H; j++){
                if(new_arr[j][per[i]] != 0){
                    q.offer(new Node(j, per[i], new_arr[j][per[i]]));
                    new_arr[j][per[i]] = 0;
                    break;
                }
            }

            while(!q.isEmpty()){
                Node now = q.poll();
                
                for(int k = 0; k < 4; k++){
                    for(int j = 1; j < now.num; j++){
                        int nx = now.x + dx[k] * j;
                        int ny = now.y + dy[k] * j;

                        if(nx < 0 || ny < 0 || nx >= H || ny >= W) continue;
                        if(new_arr[nx][ny] == 0) continue;
                        if(new_arr[nx][ny] != 1) q.offer(new Node(nx, ny, new_arr[nx][ny]));
                        new_arr[nx][ny] = 0;
                    }
                }
            }

            // 벽돌 내리기
            Stack<Integer> s = new Stack<>();
            for(int y = 0; y < W; y++){
                for(int x = 0; x < H; x++){
                    if(new_arr[x][y] != 0){
                        s.add(new_arr[x][y]);
                        new_arr[x][y] = 0;
                    }
                }
                for(int x = H-1; x >= 0; x--){
                    if(s.isEmpty()) break;
                    new_arr[x][y] = s.pop();
                }
            }
        }
        
         // 개수
        int cnt = 0;

        for(int k = 0; k < H; k++){
            for(int j = 0; j < W; j++){
                if(new_arr[k][j] != 0){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}

class Node{
    int x, y, num;

    Node(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
}