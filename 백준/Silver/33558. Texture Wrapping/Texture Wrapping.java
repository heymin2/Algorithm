import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int U = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        char[][] texture = new char[U][V];
        for (int i = 0; i < U; i++) {
            texture[i] = br.readLine().toCharArray();
        }

        String method = br.readLine();

        char[][] plane = new char[N][M];

        if (method.equals("clamp-to-edge")) {
            applyClampToEdge(plane, texture, N, M, U, V);
        } else if (method.equals("repeat")) {
            applyRepeat(plane, texture, N, M, U, V);
        } else if (method.equals("mirrored-repeat")) {
            applyMirroredRepeat(plane, texture, N, M, U, V);
        }

        printPlane(plane);
    }

    private static void applyClampToEdge(char[][] plane, char[][] texture, int N, int M, int U, int V) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int texRow = Math.min(i, U - 1);
                int texCol = Math.min(j, V - 1);
                plane[i][j] = texture[texRow][texCol];
            }
        }
    }

    private static void applyRepeat(char[][] plane, char[][] texture, int N, int M, int U, int V) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int texRow = i % U;
                int texCol = j % V;
                plane[i][j] = texture[texRow][texCol];
            }
        }
    }

    private static void applyMirroredRepeat(char[][] plane, char[][] texture, int N, int M, int U, int V) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int texRow = i % (2 * U);
                if (texRow >= U) texRow = 2 * U - 1 - texRow;

                int texCol = j % (2 * V);
                if (texCol >= V) texCol = 2 * V - 1 - texCol;

                plane[i][j] = texture[texRow][texCol];
            }
        }
    }

    private static void printPlane(char[][] plane) {
        StringBuilder sb = new StringBuilder();
        for (char[] row : plane) {
            sb.append(row).append("\n");
        }
        System.out.print(sb);
    }
}
