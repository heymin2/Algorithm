import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] arr = new boolean[21];
        int N = Integer.parseInt(br.readLine());

        for(; N > 0; N--) {
            String[] input = br.readLine().split(" ");

            if(input[0].equals("add")) {
                arr[Integer.parseInt(input[1])] = true;
            }
            else if(input[0].equals("remove")) {
                arr[Integer.parseInt(input[1])] = false;
            }
            else if(input[0].equals("check")) {
                if(arr[Integer.parseInt(input[1])]) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if(input[0].equals("toggle")) {
                arr[Integer.parseInt(input[1])] = !arr[Integer.parseInt(input[1])];
            }
            else if(input[0].equals("all")) {
                for(int i = 1; i <= 20; i++) {
                    arr[i] = true;
                }
            }
            else if(input[0].equals("empty")) {
                for(int i = 1; i <= 20; i++) {
                    arr[i] = false;
                }
            }
        }

        System.out.println(sb);
    }
}