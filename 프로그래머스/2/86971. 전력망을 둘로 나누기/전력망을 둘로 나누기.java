import java.util.*;
class Solution {
    static boolean[] visited;
    static List<Integer> adj[];
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < wires.length; i++) {
            // 끊는 전선 
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            adj = create(wires, n, i);
            visited = new boolean[n+1];
            dfs(v1);
            int cnt = 0;
            for(int a = 1; a < visited.length; a++){
                if(visited[a]){
                    cnt += 1;
                }
            }
            answer = Math.min(Math.abs(n - cnt - cnt), answer);
        }
        return answer;
    }
    static void dfs(int x) {
        if(visited[x])return;
        visited[x] = true;
        for(int next : adj[x]){
            if(visited[next])continue;
            dfs(next);
        }
    }
    
    static List<Integer>[] create(int[][] wires, int n, int x){
        List<Integer>[] graphs = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++){
            graphs[i] = new ArrayList<>();
        }
        
        for(int w = 0; w < wires.length; w++){
            if(w == x)continue;
            int a = wires[w][0];
            int b = wires[w][1];
            graphs[a].add(b);
            graphs[b].add(a);
        }
        return graphs;
        
    }
}