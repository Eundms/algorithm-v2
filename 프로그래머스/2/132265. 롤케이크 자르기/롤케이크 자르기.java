import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        // i번째 인덱스까지 토핑의 개수
        // left는 같거나 증가하므로 
        Map<Integer, Integer> cake1 = new HashMap<>();
        Map<Integer, Integer> cake2 = new HashMap<>();
        for(int i = 0; i < topping.length; i++) {
            cake2.put(topping[i], cake2.getOrDefault(topping[i],0) + 1);
        }
        
        for(int i = 0; i < topping.length; i++) {
            cake1.put(topping[i], cake1.getOrDefault(topping[i], 0) + 1);
            
            if(cake2.getOrDefault(topping[i], 0) - 1 >0){
                cake2.put(topping[i], cake2.getOrDefault(topping[i], 0) - 1);
            }else {
                cake2.remove(topping[i]);
            }
            
            if(cake1.keySet().size() == cake2.size()) {
                answer += 1;
            }
        }
        
        return answer;
    }
}