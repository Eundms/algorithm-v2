import java.util.*;
class Solution {
    static Map<Integer, Integer> map;
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        map = new HashMap<>();
        for(int t = 0; t < tangerine.length; t++) {
            int x = tangerine[t];
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        
        int all = 0;
        for(int i = 0; i < values.size(); i++) {
            all += values.get(i);
        }
        
        int removedIdx = -1;
        int removed = 0;
        for(int removeI = 0; removeI < values.size(); removeI++) {
            if (removed + values.get(removeI) <= all - k){
                removed += values.get(removeI);
                removedIdx = removeI;
                continue;
            } else {
                break;
            }
        }
        
 

        answer = values.size() - (removedIdx + 1);
        
        return answer;
    }

}