import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Nara> nara = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            nara.add(new Nara(idx, gold, silver, bronze));
        }

        nara.sort(null);

        if(nara.get(0).idx == K) System.out.println(1);
        else {
            int gold = nara.get(0).gold;
            int silver = nara.get(0).silver;
            int bronze = nara.get(0).bronze;
            int rank = 1;
            int eq = 0;

            for(int i = 1; i < N; i++) {
                if(gold == nara.get(i).gold 
                && silver == nara.get(i).silver 
                && bronze == nara.get(i).bronze) {
                    if(nara.get(i).idx == K) {
                        System.out.println(rank);
                        break;
                    }
                    eq++;
                }
                else {
                    if(nara.get(i).idx == K) {
                        System.out.println(rank+eq+1);
                        break;
                    }
                    else {
                        gold = nara.get(i).gold;
                        silver = nara.get(i).silver;
                        bronze = nara.get(i).bronze;
                        rank += eq + 1;
                        eq = 0;
                    }
                }
            }
        }
    }
}

class Nara implements Comparable<Nara> {
    int idx, gold, silver, bronze;

    public Nara(int idx, int gold, int silver, int bronze) {
        this.idx = idx;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Nara o) {
        if(this.gold == o.gold) {
            if(this.silver == o.silver) {
                return o.bronze - this.bronze;
            }
            return o.silver - this.silver;
        }
        return o.gold - this.gold;
    }
}