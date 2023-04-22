import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int idx = 0; idx < players.length ; idx++ ){
            map.put(players[idx], idx); // "Player" : 인덱스
        }
        
        for(int cIdx = 0; cIdx < callings.length; cIdx++){
            String called = callings[cIdx];
            int calledIdx = map.get(called); // 불린 사람 인덱스
            if(calledIdx>=1){

                int targetIdx = calledIdx - 1;
                String target = players[targetIdx];
                // 1. players 배열 내, 위치 변경
                 String temp = players[calledIdx];
                players[calledIdx] = players[targetIdx];
                players[targetIdx] = temp;
                
                // 2. map에 있는 called: tIdx, tIdx
                map.put(called, targetIdx);
                map.put(target, calledIdx);
            }
            
        }
        
        return players;
    }
 
}