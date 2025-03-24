import java.io.*;
import java.util.*;

public class Main {
    static class Room {
        char type;
        int money;
        List<Integer> paths = new ArrayList<>();
    }

    static Room[] rooms;
    static boolean[] visited;
    static boolean success;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            rooms = new Room[n + 1];
            visited = new boolean[n + 1];
            success = false;

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                Room room = new Room();
                room.type = st.nextToken().charAt(0);
                room.money = Integer.parseInt(st.nextToken());
                while (true) {
                    int next = Integer.parseInt(st.nextToken());
                    if (next == 0) break;
                    room.paths.add(next);
                }
                rooms[i] = room;
            }

            if (rooms[1].type == 'T') {
                success = false;
            } else {
                int startMoney = rooms[1].type == 'L' ? rooms[1].money : 0;
                visited[1] = true;
                dfs(1, startMoney);
            }

            System.out.println(success ? "Yes" : "No");
        }
    }

    static void dfs(int current, int coin) {
        if (success) return;
        if (coin < 0) return;
        if (current == n) {
            success = true;
            return;
        }

        for (int next : rooms[current].paths) {
            if (!visited[next]) {
                int nextCoin = coin;

                if (rooms[next].type == 'L' && nextCoin < rooms[next].money) {
                    nextCoin = rooms[next].money;
                } else if (rooms[next].type == 'T') {
                    nextCoin -= rooms[next].money;
                    if (nextCoin < 0) continue;
                }

                visited[next] = true;
                dfs(next, nextCoin);
                visited[next] = false;
            }
        }
    }
}
