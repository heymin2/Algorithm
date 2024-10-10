import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        List<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < wallpaper.length; i++) {
            for(int j = 0; j < wallpaper[0].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    list.add(new int[]{i, j});               
                }
            }
        }
        
        int sx = list.get(0)[0], sy = list.get(0)[1], ex = list.get(0)[0], ey = list.get(0)[1];
        
        for(int i = 1; i < list.size(); i++) {
            int[] now = list.get(i);
            
            if(now[0] > ex) ex = now[0];
            else if(now[0] < sx) sx = now[0];
          
            if(now[1] > ey) ey= now[1];
            else if(now[1] < sy) sy = now[1];
        }
        
        int[] answer = {sx, sy, ex+1, ey+1};
        return answer;
    }
}

/*

. 빈칸 # 파일o
드래그 -> 파일 선택, 삭제
최소한의 거리로 한번의 드래그로 모든 파일 선택하고 지우기
*/