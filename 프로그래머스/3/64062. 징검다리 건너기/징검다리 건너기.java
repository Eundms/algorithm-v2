class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        // stones : 징검다리(디딤돌)
        int min = 1, max = 200_000_000;
        while(min <= max) {
            int mid = (min + max) / 2;
            if(canCross(stones, k, mid)) {
                min = mid + 1;
                answer = Math.max(answer, mid);
            }else {
                max = mid - 1;
            }
        }
        return answer;
    }
    // 하루 10시간 3-6개월.. 
    static boolean canCross(int[] stones, int maxJump, int pplCnt) {
        int skip = 0;
        for(int stone : stones){
            if(stone - pplCnt < 0) {
                skip += 1;
            }else {
                skip = 0;
            }
            if(skip == maxJump){
                return false;
            }
        }
        return true;
    }
}