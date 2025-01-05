import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int monkey = Integer.parseInt(st.nextToken());
        int dog = Integer.parseInt(st.nextToken());

        int key = 0;
        int cnt = 0;

        while(true) {
            if(monkey >= dog) {
                break;
            }

            key++;

            monkey += key;
            cnt++;

            if(monkey >= dog) {
                break;
            }

            dog -= key;
            cnt++;
        }

        System.out.println(cnt);
    }
}