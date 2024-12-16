import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i <= 9; i++) {
            map.put(discount[i], map.getOrDefault(discount[i],0) + 1);
        }
        boolean isAnswer = true;
        for(int i = 0; i < want.length; i++) {
            if(map.getOrDefault(want[i],0) < number[i]) {
                isAnswer = false;
            }
        }
        if(isAnswer) {
            answer += 1 ;
        }    
        
        int N = discount.length;
        int s = 0;
        for(int e = 10; e <= N - 1; e++) {
            int v = map.get(discount[s]) - 1;
            map.put(discount[s], v);
            map.put(discount[e], map.getOrDefault(discount[e],0)+1);
            s+=1;
            isAnswer = true;
            for(int i = 0; i < want.length; i++) {
            if(map.getOrDefault(want[i],0) < number[i]) {
                isAnswer = false;
                }
            }
            if(isAnswer) {
                answer += 1 ;
            }   
        }
        return answer;
    }
}