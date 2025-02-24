import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int[] a = new int[A];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < A; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int[] b = new int[B];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < B; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(b);

            int result = 0;
            for(int i = 0; i < A; i++) {
                result += binarySearch(a[i], b);
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
	}

    private static int binarySearch(int target, int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}