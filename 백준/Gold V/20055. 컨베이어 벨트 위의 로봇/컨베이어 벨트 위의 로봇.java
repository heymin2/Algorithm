import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        List<Belt> list = new ArrayList<>();

       

        for(int i = 0; i < N*2; i++){
            list.add(new Belt(Integer.parseInt(st.nextToken()), false));
        }

        int cnt = 1; // 단계 (순서 한번 다돈것)

            while(true){
                // 순서1
                Belt tmp = list.remove(list.size()-1);
                list.add(0, tmp);
                if(list.get(N-1).robot){
                    list.get(N-1).robot =false;
                }

                // 순서2
                for(int i = N-2; i >= 0; i--){
                    if(list.get(i).robot == true){
                        int next= i+1;
                        if(list.get(next).a > 0 && !list.get(next).robot){
                            if(next != N-1){
                                list.get(next).robot = true;
                            }
                            list.get(next).a--;
                            list.get(i).robot = false;
                        }
                    }
                }


                // // 순서3
                if(list.get(0).a > 0){
                    list.get(0).a--;
                    list.get(0).robot = true;
                }

                //순서4
                if(check(list) >= K){
                    break;
                }
                cnt++;
            }
            System.out.println(cnt);
    }

    static int check(List<Belt> list){
        int sum = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).a == 0){
                sum++;
            }
        }
        return sum;
    }
}

class Belt{
    int a;
    boolean robot;

    Belt(int a, boolean robot){
        this.a = a;
        this.robot = robot;
    }
}