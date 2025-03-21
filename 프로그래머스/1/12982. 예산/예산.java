import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        int sum = 0;
        for(int x : d){
            if(sum + x <= budget){answer+=1;
                                 sum += x;}
        }
        return answer;
    }
}