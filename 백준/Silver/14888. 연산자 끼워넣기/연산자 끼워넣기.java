import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, max, min, arr[], op[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    op = new int[4];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      op[i] = Integer.parseInt(st.nextToken());
    }

    max = Integer.MIN_VALUE;
    min = Integer.MAX_VALUE;

    cal(1, arr[0]);
    sb.append(max).append("\n").append(min);

    System.out.println(sb);
  }
  
  static void cal(int cnt, int sum) {
    if (cnt == N) {
      if (max < sum) {
        max = sum;
      }

      if (min > sum) {
        min = sum;
      }
      return;
    }
    
    if (op[0] != 0) {
      op[0]--;
      cal(cnt + 1, sum + arr[cnt]);
      op[0]++;
    }
    if (op[1] != 0) {
      op[1]--;
      cal(cnt + 1, sum - arr[cnt]);
      op[1]++;
    }
    if (op[2] != 0) {
      op[2]--;
      cal(cnt + 1, sum * arr[cnt]);
      op[2]++;
    }
    if (op[3] != 0) {
      op[3]--;
      cal(cnt + 1, sum / arr[cnt]);
      op[3]++;
    }
  }
}