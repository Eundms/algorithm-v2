class Solution {
    static int N;
    static int[] selected;
    static boolean[] visited;
    static int[][] dun;
    static int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        selected = new int[N];
        visited = new boolean[N];
        dun = dungeons;
        
        back(0, k, 0);
        
        return answer;
    }
    
    static void back(int cnt, int k, int travelCnt) {
        if(cnt == N) {
            answer = Math.max(travelCnt, answer);
            
            return;
        }
        
        for(int i = 0; i < N; i++) { 
            if(visited[i])continue;
            
            visited[i] = true;

            if(dun[i][0] <= k) {
                back(cnt + 1, k - dun[i][1], travelCnt + 1);        
            }
            back(cnt + 1, k , travelCnt );        
            
            visited[i] = false;

        }
    }
}