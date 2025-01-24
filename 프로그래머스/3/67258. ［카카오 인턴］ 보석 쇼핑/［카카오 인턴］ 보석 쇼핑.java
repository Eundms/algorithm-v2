import java.util.*;
import java.io.*;
class Solution {
    static Set<String> jewels;
    public int[] solution(String[] gems) throws Exception {
        // 진열된 모든 종류의 보석을 적어도 1개 이상 포함하는 가장 짧은 구간을 찾아서 구매 
        // [시작 진열대 번호, 끝 진열대 번호]
        // 가장 짧은 구간이 여러 개라면 시작 진열대 번호가 가장 작은 구간을 return 
        jewels = new HashSet<>();
        for (String gem : gems) {
            jewels.add(gem);
        }
        int KIND_CNT = jewels.size();
        
        int minLen = Integer.MAX_VALUE;
        int start = 0, end = 0;
        Map<String, Integer> isContain = new HashMap<>();
        isContain.put(gems[0],1);
        int sIdx = 0, eIdx = 0;
        while(sIdx < gems.length && eIdx < gems.length && sIdx <= eIdx) {
            if(isContain.keySet().size() == KIND_CNT) { // all selected
                if(minLen > eIdx - sIdx + 1) {
                    minLen = eIdx - sIdx + 1;
                    start = sIdx; 
                    end = eIdx;
                }
                int prevCnt = isContain.getOrDefault(gems[sIdx], 0);
                if(prevCnt <= 1) {
                    isContain.remove(gems[sIdx]);                
                } else {
                    isContain.put(gems[sIdx], prevCnt - 1);
                }
                sIdx += 1;
                continue;
            } 
            eIdx += 1;      
            if(eIdx < gems.length){
                isContain.put(gems[eIdx], isContain.getOrDefault(gems[eIdx], 0) + 1);
            }
            
        }
        int[] answer = new int[]{start + 1, end + 1};
        return answer;
    }
}