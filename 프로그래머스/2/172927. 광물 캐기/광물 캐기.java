import java.util.*;
class Solution {
    static int minCost = Integer.MAX_VALUE;
    static int N;
    static int[][] box = {{1,1,1},{5,1,1},{25,5,1}};
    static Map<String, Integer> mineralTo;
    static String[] mineral;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        // dia, iron, stone
        mineralTo = new HashMap<>();
        mineralTo.put("diamond", 0);
        mineralTo.put("iron", 1);
        mineralTo.put("stone", 2);
        mineral = minerals;
        
        N = minerals.length;
        back(0, picks, 0);
        return minCost;
    }

    static void back(int depth, int[] picks, int cost) {
        if(depth == N) {
            minCost = Math.min(cost, minCost);
            return;
        }
        int isAllUsed = picks[0] + picks[1] + picks[2];
        if(isAllUsed == 0) {
           back(Math.min(depth + 5, N) , picks, cost);
        }
        for(int i = 0; i < 3; i++) {
            if(picks[i] > 0) { // dia, iron, stone중에 하나 선택
                int nextCost = cost;
                for(int id = depth; id < Math.min(depth + 5, N); id++) {
                    int x = i;
                    int y = mineralTo.get(mineral[id]);
                    nextCost += box[x][y]; 
                }
                picks[i] -= 1; 
                back(Math.min(depth + 5, N) , picks, nextCost);
                picks[i] += 1; 
            }
            
        }
        
    }
}