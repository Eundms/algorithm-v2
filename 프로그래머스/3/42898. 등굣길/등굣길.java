import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        boolean[][] isPossible = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                isPossible[i][j] = true;
            }
        }
        
        for(int i = 0; i < puddles.length; i++) {
            isPossible[puddles[i][1]-1][puddles[i][0]-1] = false;
        }
        int[][] dp = new int[n][m];
        dp[0][0] = 1;
       
        for(int j = 1; j < m; j++) {
            if(!isPossible[0][j] || !isPossible[0][j-1])break;
            dp[0][j] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            if(!isPossible[i][0] || !isPossible[i-1][0])break;
            dp[i][0] = 1;
        }
        
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(!isPossible[i][j])continue;
                
                if(!isPossible[i-1][j]) {
                    dp[i][j] = dp[i][j-1] % 1_000_000_007;                    
                } else if(!isPossible[i][j-1]) {
                    dp[i][j] = dp[i-1][j]%1_000_000_007;                     
                }else {
                    dp[i][j] = (dp[i-1][j]%1_000_000_007 + dp[i][j-1] % 1_000_000_007)%1_000_000_007; 
                }
                dp[i][j] %= 1_000_000_007;
            }
        }
            
        return dp[n-1][m-1]%1_000_000_007;
    }

}