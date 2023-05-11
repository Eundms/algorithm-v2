import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for(int i = 0;  i < arr.length; i++){
            if(arr[i] % divisor == 0){
                answer.add(arr[i]);
            }
        }
        
        Collections.sort(answer);
        
        int[] res = new int[answer.size()];
        if(answer.size() > 0){
            for(int i = 0; i < res.length; i++){
                res[i] = answer.get(i);
            }
            return res;
        }else{
            return new int[]{-1};
        }
    }
}