import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int[] arr = new int[10_000_001];
        
        for(int i = 0; i < tangerine.length; i++) {
            arr[tangerine[i]]++;
        }
        
        Arrays.sort(arr);
        
        int cnt = 0;
        for(int i = 10_000_000; i >= 0; i--) {
            if(k > 0) {
                k -= arr[i];
                cnt++;
            }
            else break;
        }
        
        return cnt;
    }
}