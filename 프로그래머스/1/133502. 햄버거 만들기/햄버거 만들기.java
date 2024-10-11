import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] ingredient) {
        List<Integer> list = new ArrayList<>();
        int result = 0;
        
        for(int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
            
            while(list.size() >= 4) {
                int size = list.size();
                
                if(!(list.get(size - 1) == 1 &&
                  list.get(size - 2) == 3 &&
                  list.get(size - 3) == 2 &&
                  list.get(size - 4) == 1)) {
                    break;
                }
                    
                for(int j = 0; j < 4; j++) {
                    list.remove(list.size()-1);
                }
                result++; 
            }
        }
        
        return result;
    }
}