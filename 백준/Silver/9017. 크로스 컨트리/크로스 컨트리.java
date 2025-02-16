import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(; T > 0; T--) {
            int N = Integer.parseInt(br.readLine());

            int[] rank = new int[N];
            int[] team = new int[201];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int now = Integer.parseInt(st.nextToken());
                
                rank[i] = now;
                team[now]++;
            }

            List<Rank> list = new ArrayList<>();
            for(int i = 0; i <= 200; i++) {
                list.add(new Rank(i));
            }

            int score = 1;
            for(int i = 0; i < N; i++) {
                if(team[rank[i]] == 6) {
                    if(list.get(rank[i]).cnt < 4) {
                        list.get(rank[i]).total += score;
                    }
                    else if(list.get(rank[i]).cnt == 4) {
                        list.get(rank[i]).lastScore += score;
                    }
                    list.get(rank[i]).cnt += 1;
                    score++;
                } 
            }

            list.sort(null);
            
            for(int i = 0; i <= 200; i++) {
                if(list.get(i).total != 0) {
                    sb.append(list.get(i).team).append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
	}
}

class Rank implements Comparable<Rank> {
    int team, lastScore, cnt, total;

    public Rank(int team) {
        this.team = team;
    }

    @Override
    public int compareTo(Rank o) {
        if(this.total == o.total) {
            return this.lastScore - o.lastScore;
        }
        return this.total - o.total;
    }
}