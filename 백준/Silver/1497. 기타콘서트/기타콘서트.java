import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static List<Guitar> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            long bit = strToLong(st.nextToken());
            list.add(new Guitar(name, bit));
        }

        dfs(0, 0, 0);
        System.out.println(max == 0 ? -1 : min);
    }

    static void dfs(int idx, long playSong, int cnt) {
        int play = Long.bitCount(playSong);
        if(play == max && min > cnt) {
            min = cnt;
        }

        if(play > max) {
            max = play;
            min = cnt;
        }

        if(idx == N || play == M) {
            return;
        }

        dfs(idx + 1, playSong | list.get(idx).playableSongs, cnt+1);
        dfs(idx + 1, playSong, cnt);
    }

    static long strToLong(String song) {
        long sum = 0;
        for (int i = 0; i < M; i++) {
            char key = song.charAt(i);
            if (key == 'Y') {
                sum += 1L << i;
            }
        }
        return sum;
    }
}

class Guitar {
    String name;
    long playableSongs;

    Guitar(String name, long playableSongs) {
        this.name = name;
        this.playableSongs = playableSongs;
    }
}
