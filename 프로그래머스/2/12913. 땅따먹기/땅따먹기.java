class Solution {
    static int ROW, COL;
    static int answer = 0;
    static int[][] box;
    int solution(int[][] land) {
        ROW = land.length;
        COL = land[0].length;
        box = land;

        int[][] dp = new int[ROW][COL];
        for(int c = 0; c < COL; c++){
            dp[0][c] = box[0][c];
        }
        
        for(int r = 1; r < ROW; r++) {
            for(int c = 0; c < COL; c++){
                for(int j = 0; j < COL; j++){
                    if(c==j)continue;
                    dp[r][c] = Math.max(box[r][c] + dp[r-1][j], dp[r][c]);
                }
            }
        }
        
        for(int c = 0; c < COL; c++) {
            answer = Math.max(dp[ROW-1][c], answer);    
        }

        return answer;
    }

}