import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N, index[], arr[];
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        index = new int[N];
        arr = new int[N];
        list = new ArrayList<>();

         list.add(Integer.MIN_VALUE); // 처음에 값 안넣어주면 오류 생김

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            if (list.get(list.size()-1) < num) {
                list.add(num);
                index[i] = list.size()-1;
            } else {
                int left = 1;
                int right = list.size()-1;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (list.get(mid) < num) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }

                list.set(right,num);
                index[i] = right;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()-1).append("\n");

        Stack<Integer> stack = new Stack<>();
        int idx = list.size()-1;

        for(int i = N-1; i >= 0; i--){
            if(index[i] == idx){
                idx--;

                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }
}