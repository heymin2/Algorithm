import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] arr;
    static List<Integer>[] list;
    static List<K> blank;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int[] score = {0,1,10,100,1000};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        list = new ArrayList[N*N + 1];

        for (int i = 1; i <= N * N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 4; j++) {
                list[idx].add(Integer.parseInt(st.nextToken()));
            }

            if (i == 0) {
                arr[1][1] = idx;
            } else {
                blank = new ArrayList<>();
                check(idx);
            }
        }

        int sum = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sum += score[re(i, j, arr[i][j])];
            }
        }

        System.out.println(sum);
    }

    static int re(int x, int y, int idx){
        int cnt = 0;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;

            if (list[idx].contains(arr[nx][ny])) {
                cnt++;
            }
        }
        
        return cnt;
    }

    static void check(int idx) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    int love = 0; // 좋아하는 학생 몇명
                    int cnt = 0; // 인접 빈칸 몇개

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N)
                            continue;

                        if (arr[nx][ny] == 0) {
                            cnt++;
                        } else if (list[idx].contains(arr[nx][ny])) {
                            love++;
                        }
                    }
                    blank.add(new K(i, j, cnt, love));
                }
            }
        }

        Collections.sort(blank);

        arr[blank.get(0).x][blank.get(0).y] = idx;
    }
}

class K implements Comparable<K> {
    int x, y, cnt, love;

    K(int x, int y, int cnt, int love) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
        this.love = love;
    }

    @Override
    public int compareTo(K o) {
        if(love == o.love){
            if(cnt == o.cnt){
                if (x == o.x) {
                    return y - o.y;
                }
                return x - o.x;
            }
            return o.cnt - cnt;
        }
        return o.love - love;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + cnt + " " + love;
    }
}