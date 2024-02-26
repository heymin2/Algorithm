import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
        List<calendar> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());

            list.add(new calendar(s, e));
		}

        list.sort(null);
		
        int start = 301;
        int end = 1201;
        int cnt = 0;
        int idx = 0;
        int max = 0;

        while(start < end){
            boolean flag = false;

            for(int i = idx; i < N; i++){
                if(list.get(i).start > start) break;

                if(max < list.get(i).end){
                    flag = true;
                    max = list.get(i).end;
                    idx = i+1;
                }
            }

            if(flag){
                start = max;
                cnt++;
            }
            else break;
        }

        if(max < end){
            System.out.println(0);
        }
        else{
            System.out.println(cnt);
        }
	}
}

class calendar implements Comparable<calendar>{
    int start, end;

    calendar(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(calendar o) {
        if(start == o.start){
            return end - o.end;
        }
       return start - o.start;
    }
}