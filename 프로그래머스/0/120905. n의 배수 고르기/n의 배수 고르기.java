import java.util.*;
class Solution {
    public int[] solution(int n, int[] numlist) {
        List<Integer> ans = new ArrayList<>();
        
        for(int x : numlist){
            if(x%n == 0){
                ans.add(x);
            }
        }
        
        
        int[] answer = new int[ans.size()];
        int i = 0;
        for(int a : ans){
            answer[i++] = a;
        }
        return answer;
    }
}