import java.io.*;
import java.util.*;

public class Main {

    static int[] required = new int[4];  // 최소 조건
    static int[] current = new int[4];   // 현재 윈도우 상태

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 전체 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 윈도우 길이
        String str = br.readLine();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            required[i] = Integer.parseInt(st.nextToken());
        }

        // 초기 윈도우
        for (int i = 0; i < P; i++) {
            current[charToIndex(str.charAt(i))]++;
        }

        int result = 0;
        if (isValid()) result++;

        // 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            current[charToIndex(str.charAt(i - P))]--; // 앞 문자 제거
            current[charToIndex(str.charAt(i))]++;     // 새 문자 추가

            if (isValid()) result++;
        }

        System.out.println(result);
    }

    static int charToIndex(char c) {
        switch (c) {
            case 'A': return 0;
            case 'C': return 1;
            case 'G': return 2;
            case 'T': return 3;
        }
        return -1; // 절대 도달하지 않음
    }

    static boolean isValid() {
        for (int i = 0; i < 4; i++) {
            if (current[i] < required[i]) return false;
        }
        return true;
    }
}