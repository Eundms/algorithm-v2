import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int left = 0, right = 10000; // h 편 설정
        
        while(left <= right) {
            int h = (right - left) / 2 + left;
            if(isValid(citations, h)) {
                answer = Math.max(answer, h);
                left = h + 1;
            } else {
                right = h - 1;
            }
            
        }
        System.out.println(left);
        
        
        return answer;
    }
    public boolean isValid(int[] citations, int h) {
        int cnt = 0;
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= h) {
                cnt += 1;
            }
        }
        return cnt >= h;
    }
}