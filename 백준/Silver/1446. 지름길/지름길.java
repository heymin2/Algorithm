import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Node> list = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if(D >= end && end - start > length) {
                list.add(new Node(start, end, length));
            }
        }

        list.sort(null);

        int[] distance = new int[D+1];
        int cnt = 0;
        int idx = 0;
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;

        while (cnt < D){
            if (idx < list.size()) {
                Node s = list.get(idx);
                if (cnt == s.start) {
                    distance[s.end] = Math.min(distance[cnt] + s.length, distance[s.end]);
                    idx++;
                } 
                else {
                    distance[cnt + 1] = Math.min(distance[cnt + 1], distance[cnt] + 1);
                    cnt++;
                }
            } 
            else {
                distance[cnt + 1] = Math.min(distance[cnt + 1], distance[cnt] + 1);
                cnt++;
            }
        }

        System.out.println(distance[D]);
    }
}

class Node implements Comparable<Node>{
    int start, end, length;

    public Node(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    @Override
    public int compareTo(Node o) {
        if(this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}