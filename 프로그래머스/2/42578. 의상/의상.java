import java.util.*;
class Solution {
    static Map<String, List<String>> kinds = new HashMap<>();
    public int solution(String[][] clothes) {
        for(int i = 0; i < clothes.length; i++) {
            String name = clothes[i][0];
            String category = clothes[i][1];
            
            List<String> names = kinds.getOrDefault(category, new ArrayList<>());
            names.add(name);
            kinds.put(category, names);
        }
        List<String> keys = new ArrayList<>(kinds.keySet());
   
        int answer = 1;
        
        for(String key: kinds.keySet()) {
            answer *= kinds.get(key).size() + 1;
        }

        return answer - 1;
    }
}