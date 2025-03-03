import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Queue<Integer>> indexA = new HashMap<>();
        Map<Integer, Queue<Integer>> indexB = new HashMap<>();

        for (int i = 0; i < N; i++) {
            indexA.putIfAbsent(A[i], new LinkedList<>());
            indexA.get(A[i]).offer(i);

            indexB.putIfAbsent(B[i], new LinkedList<>());
            indexB.get(B[i]).offer(i);
        }

        int[] newA = Arrays.copyOf(A, N);
        int[] newB = new int[N];
        Arrays.fill(newB, -1);

        boolean[] usedA = new boolean[N];
        boolean[] usedB = new boolean[N];

        int max = 0;

        for (int key : indexA.keySet()) {
            if (indexB.containsKey(key)) {
                Queue<Integer> queueA = indexA.get(key);
                Queue<Integer> queueB = indexB.get(key);

                while (!queueA.isEmpty() && !queueB.isEmpty()) {
                    int idxA = queueA.poll();
                    int idxB = queueB.poll();

                    newA[idxA] = key;
                    newB[idxA] = key;
                    usedA[idxA] = true;
                    usedB[idxB] = true;
                    max++;
                }
            }
        }

        int bIdx = 0;
        for (int i = 0; i < N; i++) {
            if (newB[i] == -1) {
                while (bIdx < N && usedB[bIdx]) {
                    bIdx++;
                }
                if (bIdx < N) {
                    newB[i] = B[bIdx];
                    usedB[bIdx] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");

        for (int i = 0; i < N; i++) {
            sb.append(newA[i]).append(" ");
        }
        sb.append("\n");

        for (int i = 0; i < N; i++) {
            sb.append(newB[i]).append(" ");
        }

        System.out.println(sb);
    }
}
