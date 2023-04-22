import java.lang.*;
import java.util.*;
class Solution {
    public int solution(int n) {
        Set<Integer> list = new HashSet<>();
        int answer = 0;
        for(int i = 1; i<=Math.sqrt(n); i++){
            if(n%i==0){
                list.add(i);
                list.add(n/i);
            }
        }
        List<Integer> targetList = new ArrayList<>(list);
        for(int i = 0 ; i < targetList.size(); i++){
            answer += targetList.get(i);
        }
        return answer;
    }
}