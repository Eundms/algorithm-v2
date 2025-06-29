import java.util.*;
class Solution {
    static int N;
    static int[][] way = {{0,1},{1,0},{0,-1},{-1,0}};
    static int[][][] cost;
    public int solution(int[][] box) {
        int answer = 0;
        N = box.length;
        cost = new int[N][N][4];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        // x , y, 방향, 비용
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[3]));
        pq.add(new int[]{0, 0, -1, 0 });
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[0] == N-1 && now[1] == N-1){
                return now[3];
            }
            for(int w = 0; w < 4; w ++){
                int nx  = now[0] + way[w][0];
                int ny = now[1] + way[w][1];
                if(!inRange(nx, ny) || box[nx][ny] == 1)continue;
                int next = now[3] + ((now[2] == -1 || now[2] == w) ? 100 : 600);
                if(cost[nx][ny][w] > next) {
                    cost[nx][ny][w] = next;
                    pq.add(new int[]{nx, ny, w, next});
                }
            }
        }
        return 0;
    }
        static boolean inRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

}