import java.util.*;
class Solution {
    static int N;
    public int solution(int[][] triangle) {
        // 거쳐간 숫자의 합이 가장 큰 경우
        // 대각선 방향으로 한칸 오른쪽(1,1) 또는 왼쪽(1,0)으로 이동 
        N = triangle.length;
        
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i+1; j++) {
                if(j == 0) {
                     triangle[i][j] += triangle[i-1][j];
                } else if(j == i) {
                    triangle[i][j] += triangle[i-1][j-1];
                } else {
                    triangle[i][j]  += Math.max(triangle[i-1][j-1],  triangle[i-1][j]);
  
                }
            }
        }
        
        int answer = 0;
        for(int j = 0; j < N; j++) {
            answer = Math.max(answer, triangle[N-1][j]);
        }
        
        return answer;
    }
}