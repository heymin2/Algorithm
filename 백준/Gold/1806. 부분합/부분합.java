import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int S = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int sum = arr[0];
    int a = 0;
    int b = 0;
    int min = 100_001;

    while (true) {
      if (a == N - 1) {
        if (sum >= S)
          min = Math.min(min, b - a + 1);
        break;
      } else if (sum >= S) {
        min = Math.min(min, b - a + 1);
        sum -= arr[a];
        a++;
      } else if (a == b) {
        b++;
        sum += arr[b];
      } else {
        if (b < N - 1) {
          b++;
          sum += arr[b];
        } else if (b >= N - 1) {
          sum -= arr[a];
          a++;
        }
      }
    }
    
    if (min == 100_001) {
      System.out.println(0);
    }
    else {
      System.out.println(min);
    }
  }
}