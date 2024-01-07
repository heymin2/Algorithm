import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int N;
    static ArrayList<Integer>[] list;
    static int[] parent;
    static boolean[] check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        list = new ArrayList[N+1];
        parent = new int[N+1];
        check = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

        for(int i = 0; i < N-1; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();

            list[s].add(e);
			list[e].add(s);
        }

        dfs(1);

        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }

    static void dfs(int start){
        check[start] = true;

        for (int j = 0; j < list[start].size(); j++) {
            int i = list[start].get(j);
            if (!check[i]) {
                parent[i] = start;
                dfs(i);
            }
        }
    }
}
