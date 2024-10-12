import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        // 정답 배열 생성
        int[] answer = new int[targets.length];
        
        // HashMap 생성
        HashMap<Character, Integer> hash = new HashMap<>();
        
        // keymap에서 각 문자와 해당 위치를 저장
        for(int i = 0; i < keymap.length; i++) {
            for(int j = 0; j < keymap[i].length(); j++) {
                char now = keymap[i].charAt(j);
                
                // 이미 존재하는 문자라면 최소값을 유지
                if(hash.containsKey(now)) {
                    hash.put(now, Math.min(hash.get(now), j + 1)); // 위치를 1부터 시작하도록 조정
                } else {
                    hash.put(now, j + 1); // 위치를 1부터 시작하도록 조정
                }
            }
        }
        
        // 각 타겟에 대해 계산
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int count = 0;
            boolean isPossible = true;

            for (int j = 0; j < target.length(); j++) {
                char t = target.charAt(j);

                if (hash.containsKey(t)) {
                    count += hash.get(t);  // 해당 문자의 최소 위치값을 더함
                } else {
                    isPossible = false;  // 해당 문자가 keymap에 없으면 -1로 처리
                    break;
                }
            }

            answer[i] = isPossible ? count : -1;  // 타겟 문자열을 모두 탐색한 결과
        }

        return answer;  // 최종 결과 반환
    }
}
