import java.util.*;
class Solution {
    static int N, M;
    static Map<Integer, Integer> idToCnt;
    static int[][] way = {{-1,0},{1,0},{0,1},{0,-1}};
    
    static int[][] grouped;
    public int solution(int[][] land) {
        // land bfs로 돌면서 id 매기기 id에 해당하는 크기 구하기 
        N = land.length;
        M = land[0].length;
        
        idToCnt = new HashMap<>();
        int groupId = 1;
        grouped = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(land[i][j] == 0)continue;
                if(grouped[i][j] == 0) { // 방문한 적이 없다면 
                    int inGroupCnt = bfs(i, j, groupId, land); 
                    idToCnt.put(groupId, inGroupCnt);
                    groupId += 1;
                }
            }
        }
 
        int maxAmount = 0;
        for(int j = 0; j < M; j++) {
            Set<Integer> groupIds = new HashSet<>();
            for(int i = 0; i < N; i++) {
                if(grouped[i][j] > 0) {
                   groupIds.add(grouped[i][j]);                
                }
            }
            int amount = 0;
            for(int id : groupIds) {
                amount += idToCnt.get(id);
            } 
            maxAmount = Math.max(maxAmount, amount);
        }
        return maxAmount;
    }
    static int bfs(int i, int j, int groupId, int[][] land) {
        int inGroupCnt = 1;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        grouped[i][j] = groupId;
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for(int w = 0; w < 4; w++) {
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M)continue;
                if(land[nx][ny] == 1 && grouped[nx][ny] == 0) {
                    grouped[nx][ny] = groupId;
                    inGroupCnt += 1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
        
        return inGroupCnt;
    }
}