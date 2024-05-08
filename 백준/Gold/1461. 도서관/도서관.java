import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer> negative, positive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        negative = new ArrayList<>();
		positive = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int book = Integer.parseInt(st.nextToken());
			if (book > 0) positive.add(book);
			else negative.add(book);
		}

		Collections.sort(negative);
		Collections.sort(positive, Collections.reverseOrder());

        ArrayList<Integer> distance = new ArrayList<>();
		while(!negative.isEmpty()) {
			int temp=0; 
			temp = negative.remove(0);
			for (int i=1; i<M; i++) {
				if (!negative.isEmpty()) {
					negative.remove(0);
				}
			}
			distance.add(-temp);
		}
		
		while(!positive.isEmpty()) {
			int temp=0;
			temp = positive.remove(0);
			for (int i=1; i<M; i++) {
				if (!positive.isEmpty()) {
					positive.remove(0);
				}	
			}
			distance.add(temp);
		}
		
		int result = 0;
		Collections.sort(distance);
		for (int i=0; i<distance.size(); i++) {
			if (i == distance.size()-1) result += distance.get(i);
			else result += (distance.get(i)*2);
		}
		
		System.out.println(result);
    }
}