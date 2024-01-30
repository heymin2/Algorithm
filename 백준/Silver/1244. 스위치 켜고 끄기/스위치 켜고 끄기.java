import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (s == 1) {
                int idx = 1;
                while (num * idx <= N) {
                    if (arr[num * idx] == 1)
                        arr[num * idx] = 0;
                    else
                        arr[num * idx] = 1;
                    idx++;
                }
            } else {
                int j = 1;
                if (arr[num] == 1) {
                    arr[num] = 0;
                } else {
                    arr[num] = 1;
                }
                while (true) {
                    if (num - j < 1 || num + j > N) {
                        break;
                    }
                    if (arr[num - j] == arr[num + j]) {
                        if (arr[num - j] == 1) {
                            arr[num - j] = 0;
                        } else {
                            arr[num - j] = 1;

                        }
                        if (arr[num + j] == 1) {
                            arr[num + j] = 0;
                        } else {
                            arr[num + j] = 1;

                        }
                    } else {
                        break;
                    }
                    j++;
                }
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append(" ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}