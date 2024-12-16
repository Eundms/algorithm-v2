import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < progresses.length; i++) {
            progresses[i] = (int)Math.ceil((double)(100 - progresses[i])/speeds[i]);
        }
        System.out.println(Arrays.toString(progresses));
        // 연속적으로 증가하는 수열 찾기
        
        int cnt = 0;
        int prev = progresses[0];
        for(int i = 0; i < progresses.length; i++) {
            if(prev >= progresses[i]) {
                cnt += 1;
            } else {
                ans.add(cnt);
                cnt = 1;
            }
           prev = Math.max(prev,progresses[i]);
        }
        if(cnt > 0) {
            ans.add(cnt);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}