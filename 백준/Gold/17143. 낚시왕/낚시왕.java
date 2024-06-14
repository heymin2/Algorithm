import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int R, C, M, sum;
    static int dx[] = {0,-1,1,0,0};
    static int dy[] = {0,0,0,1,-1};
    static Node map[][];
    static List<Node>list = new ArrayList<>();
    static List<Node> tmp = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Node[R+1][C+1];
        
        for(int i=0; i<M; i++) {
           st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            
            if(d == 1 || d == 2) s = s % (R*2-2);
			if(d == 3 || d == 4) s = s % (C*2-2);

            Node node = new Node(r,c,s,d,z);
            map[r][c] = node;
            list.add(node);
        }
        if(M==0) {
            System.out.println(0);
            return;
        }

        sum = 0;

        for(int i = 1; i <= C; i++) {
            hunt_shark(i);
            move_shark();
            eat_shark();
        }
        System.out.println(sum);
    }
    
    static void eat_shark() {
        for(int i= list.size()-1; i>=0; i--) {
            Node a = list.get(i);
            
            if(map[a.x][a.y]==null) {
                map[a.x][a.y] = a;
            }
            else {
                if(map[a.x][a.y].z > a.z) {
                    list.remove(a);
                }
                else {
                    list.remove(map[a.x][a.y]);
                    map[a.x][a.y]= a;
                }
            }
        }
    }
    
    static void move_shark() {
        for(int i=0; i<list.size(); i++) {
            Node a=  list.get(i);
            map[a.x][a.y] = null;
            int x = a.x;
            int y = a.y;
            int s = a.s;
            int d = a.d;
            int z = a.z;

            for(int j=0; j<s; j++) {
                if(isRange(x+dx[d],y+dy[d])) {
                    x+=dx[d];
                    y+=dy[d];
                }
                else {
                    d = change_dir(d);
                    x+=dx[d];
                    y+=dy[d];
                }
            }
            tmp.add(new Node(x,y,s,d,z));
        }
        list.clear();
        for(int i=0; i<tmp.size(); i++) {
            list.add(tmp.get(i));
        }
        tmp.clear();
    }

    static void hunt_shark (int fisher_pos) {
        for(int i=1; i<=R; i++) {
            if(map[i][fisher_pos] != null) {
                sum += map[i][fisher_pos].z;
                list.remove(map[i][fisher_pos]);
                map[i][fisher_pos]= null;
                break;
            }
        }
    }
    
    static boolean isRange(int x, int y) {
        if(x>=1 && y>=1 && x<=R && y<=C) {
            return true;
        }
        return false;
    }
    
    static int change_dir(int d) {
        switch(d) {
        case 1:
            return 2;
        case 2:
            return 1;
        case 3:
            return 4;
        case 4:
            return 3;
        }
        return -1;
    }
}

class Node{
    int x,y,s,d,z;
    Node(int x, int y, int s, int d , int z){
        this.x=x;
        this.y=y;
        this.s=s;
        this.d=d;
        this.z=z;
    }
}