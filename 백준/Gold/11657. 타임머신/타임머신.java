import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[] dist;
    static List<List<Node>> city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new ArrayList<>();
        dist = new long[N+1];

        for(int i = 0; i <= N; i++) {
            city.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            city.get(A).add(new Node(B, C));
        }

        if(bellmanFord()) sb.append("-1\n");
        else {
            for(int i = 2; i <= N; i++) {
                if(dist[i] == Integer.MAX_VALUE) sb.append("-1\n");
                else sb.append(dist[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean bellmanFord() {
        dist[1] = 0;
        boolean update = false;

        for(int i = 1; i < N; i++) {
            update = false;

            for(int j = 1; j<= N; j++) {
                for(Node node : city.get(j)){
                    if(dist[j] ==Integer.MAX_VALUE) break;

                    if(dist[node.end] > dist[j] + node.time) {
                        dist[node.end] = dist[j] + node.time;
                        update = true;
                    }
                }
            }

            if(!update) break;
        }

        if(update) {
            for(int i = 1; i <= N; i++) {
                for(Node node: city.get(i)) {
                    if(dist[i] ==Integer.MAX_VALUE) break;

                    if(dist[node.end] > dist[i] + node.time) return true;
                }
            }
        }
        return false;
    }
}

class Node {
    int end;
    int time;

    Node(int end, int time) {
        this.end = end;
        this.time = time;
    }
}