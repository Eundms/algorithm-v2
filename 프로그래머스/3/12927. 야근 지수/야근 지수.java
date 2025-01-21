import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int w = 0; w< works.length; w++){
            pq.add(works[w]);
        }
        while(n-- > 0 && !pq.isEmpty()){
            int v = pq.poll();
            if(v > 0){
                pq.add(v - 1);            
            }
        }
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(),2);
        }
        return answer;
    }
}