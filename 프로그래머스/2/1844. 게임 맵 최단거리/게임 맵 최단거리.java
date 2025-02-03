import java.util.*;
class Solution {
    static int[][] way = {{0,-1},{0,1},{1,0}, {-1,0}};
    static int N, M;
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        int answer = 0;
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];
            if(visited[x][y])continue;
            visited[x][y] = true;
            
            for(int w = 0; w < 4; w++) {
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];
                if(!inRange(nx, ny) || visited[nx][ny]) continue;
                if(maps[nx][ny] != 0) { 
                    maps[nx][ny] = maps[x][y] + 1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }

        return maps[N-1][M-1] == 1? -1 : maps[N-1][M-1];
        
    }
    static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}