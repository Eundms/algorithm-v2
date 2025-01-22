import java.util.*;
class Solution {
    // 0, 0 에서 N-1, N-1 이동 최소 비용
    // 방향 전환 (=코너) : 500
    // 총 경로 - 1 : 100
    static int N, M;
    static int[][] way = {  {0,1}, {1,0}, {-1,0}, {0,-1}}; // 0 1 2 3
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        N = board.length; 
        M = board[0].length;
        
        int[][][] cost = new int[N][M][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0,  -1}); // 0,0 좌표 | 지금까지 cost | 방향 
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if(now[0] == N-1 && now[1] == M-1) {
                answer = Math.min(answer, now[2]);
                continue;
            }
            for (int w = 0; w < 4; w++) {
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];
                if(!inRange(nx, ny)) continue;
                if(board[nx][ny] == 0){
                    int nextCost = now[2] + (now[3] == -1 || now[3] == w || now[3] == 3 - w  ? 100  : 600);
                    if(cost[nx][ny][w] > nextCost) {
                        cost[nx][ny][w] = nextCost;
                        queue.add(new int[]{nx, ny, nextCost, w});
                        
                    }
                }
            }
        }
        return answer;
    }
    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}