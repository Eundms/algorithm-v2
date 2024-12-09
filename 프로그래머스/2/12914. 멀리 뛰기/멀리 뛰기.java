class Solution {
    public long solution(int n) {
        long answer = 0;
        // dp[i] = dp[i-1] + dp[i-2]; // 한번에 1칸 또는 2칸 뛸 수 있음 
        if(n <= 2) {
            return n;
        }
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567; // dp[3] = dp[2] + dp[1]; 
        }
        answer = dp[n] % 1234567;
        return answer;
    }
}