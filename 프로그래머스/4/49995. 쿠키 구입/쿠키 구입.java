class Solution {
    static int N;
    static int[] leftFromSum;
    public int solution(int[] cookie) {
        int answer = 0;
        N = cookie.length;
        
        leftFromSum = new int[N];
        leftFromSum[0] = cookie[0];
        for(int i = 1; i < N; i++) {
            leftFromSum[i] += leftFromSum[i-1] + cookie[i]; 
        }
        
        for(int m = 0; m <= N - 2; m++) { // m부터 왼쪽 누적합, m+1부터 오른쪽 누적합
            int left  = m;
            int right = m + 1;
            
            int lSum = cookie[left];
            int rSum = cookie[right];
            
            while(left >= 0 && right < N) {
                if(lSum == rSum) {
                    answer = Math.max(answer, lSum);
                    
                    left--;
                    right++;
                
                    if(left >= 0) lSum += cookie[left];
                    if(right < N) rSum += cookie[right];
                    
                } else if(lSum < rSum) {
                    left--;
                    if(left >= 0) lSum += cookie[left];
                } else {
                    right++;
                    if(right < N) rSum += cookie[right];
                }
                
            }
        }
        return answer;
    }
}