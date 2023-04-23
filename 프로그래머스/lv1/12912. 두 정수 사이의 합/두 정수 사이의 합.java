import java.util.*;
class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int minV = Math.min(a,b);
        int maxV = Math.max(a,b);
        for(int v = minV; v<=maxV; v++){
            answer+=v;
        }
        return answer;
    }
}