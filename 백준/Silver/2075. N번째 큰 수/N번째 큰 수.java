import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Vector<Integer> v = new Vector<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				v.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		v.sort((o1, o2) -> o2 - o1);
		
		System.out.println(v.get(N-1));
	}
}
