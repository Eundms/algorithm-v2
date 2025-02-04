import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville){
            pq.add(s);        
        }

        int cnt = 0;
        while(true){
            if(pq.size() < 2)break;
            if(pq.peek() >= K)break;
            int min = pq.poll();
            int secondMin = pq.poll();
            int mixed = min + (secondMin * 2);
            pq.add(mixed);
            cnt += 1;
        }
        if(pq.peek() < K) {
            return -1;
        }
        
        return cnt;
    }
}