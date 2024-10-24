class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        int groupValue = 0;
        for(int i = 0; i < computers.length; i++){
            if(!visited[i]){
                groupValue++;
                dfs(i, computers);            
            }
        }
        return groupValue;
    }
    static void dfs(int x, int[][] computers) {
        if(visited[x]){
           return; 
        }
        visited[x] = true;
        for(int i = 0; i < computers[0].length; i++){
            if(visited[i])continue;
            if(computers[x][i]==1){
                dfs(i,  computers);
            }
        }
    }
}