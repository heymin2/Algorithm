import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int monkey = Integer.parseInt(st.nextToken());
        int dog = Integer.parseInt(st.nextToken());

        int key = 1;
        int cnt = 0;

        while(true) {
            if(monkey >= dog) {
                break;
            }

            monkey += key;
            cnt++;

            if(monkey >= dog) {
                break;
            }

            dog -= key;
            cnt++;

            key++;
        }

        System.out.println(cnt);
    }
}