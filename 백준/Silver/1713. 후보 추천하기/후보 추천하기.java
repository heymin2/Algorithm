import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 사진틀 개수

        int M = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < M; i++){
            int value = Integer.parseInt(st.nextToken());
            int check = 0;
            
            if(list.size() < N){
                for(int j = 0; j < list.size(); j++){
                    if(list.get(j).s == value){
                        list.get(j).cnt++;
                        check = 1;
                        break;
                    }
                }

                if(check == 0){
                    list.add(new Student(i, value, 1));
                }
            }
            else{
                Collections.sort(list);
                for(int j = 0; j < list.size(); j++){
                    if(list.get(j).s == value){
                        list.get(j).cnt++;
                        check = 1;
                        break;
                    }
                }

               if(check == 0){
                list.remove(0);
                list.add(new Student(i, value, 1));
               }
            }
        }

        StringBuilder sb = new StringBuilder();

        List<Integer> result = new ArrayList<>();
        
        for(int i = 0; i < list.size(); i++){
            result.add(list.get(i).s);
        }

        result.sort(null);

        for(int i = 0; i < result.size(); i++){
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}

class Student implements Comparable<Student>{
    int idx, s, cnt;

    Student(int idx, int s, int cnt){
        this.idx = idx;
        this.s = s;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Student o) {
        if(this.cnt == o.cnt){
            return this.idx - o.idx;
        }
        return this.cnt - o.cnt;
    }
}