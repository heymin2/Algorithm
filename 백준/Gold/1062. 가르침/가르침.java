import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static List<String> words;
    static boolean[] alpha = new boolean[26];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 단어의 개수
        K = Integer.parseInt(st.nextToken()); // 가르칠 수 있는 글자수

        words = new ArrayList<>(); // 남극 단어
        
        for(int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        // 풀이
        if(K < 5) System.out.println(0); // 기본으로 익혀야하는 글자 a n t i c (5개)
        else {
            alpha['a' - 'a'] = true;
            alpha['n' - 'a'] = true;
            alpha['t' - 'a'] = true;
            alpha['i' - 'a'] = true;
            alpha['c' - 'a'] = true;

            dfs(0, 0);
            System.out.println(max);
        }
        
    }

    static void dfs(int idx, int cnt) {
        if(cnt + 5 == K) {
            countWord();
            return;
        }

        for(int i = idx; i < 26; i++) {
            if(alpha[i]) continue;

            alpha[i] = true;
            dfs(i+1, cnt+1);
            alpha[i] = false;
        }
    }

    static void countWord() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            boolean flag = true;
            for(int j = 0; j < words.get(i).length(); j++) {
                if(!alpha[words.get(i).charAt(j) - 'a']) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                cnt++;
            }
        }

        max = Math.max(max, cnt);
    }
}