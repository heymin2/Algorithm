import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] visit;
    static List<List<Integer>> result;
    static Set<String> unique;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        result = new ArrayList<>();
        unique = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        dfs(0, 0, temp);

        StringBuilder sb = new StringBuilder();
        for(List<Integer> list : result) {
            for(int num : list) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int depth, int start, List<Integer> temp) {
        if(depth == M) {
            String key = temp.toString();
            if (!unique.contains(key)) {
                unique.add(key);
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        for(int i = start; i < N; i++) {
            if(i > start && arr[i] == arr[i-1]) continue;
            temp.add(arr[i]);
            dfs(depth+1, i+1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}