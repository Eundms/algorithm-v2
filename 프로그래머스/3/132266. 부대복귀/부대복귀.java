import java.util.*;
class Solution {
    static int[] dist;
    static List<Node>adj[];
    static PriorityQueue<Node> pq; 
    // 총 지역의 수 | 왕복 길 정보들 | 서로 다른 지역들 | 강철부대 지역 
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            adj[road[0] - 1].add(new Node(road[1] - 1, 1));
            adj[road[1] - 1].add(new Node(road[0] - 1, 1));
        }
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); // destination으로부터 거리

        pq = new PriorityQueue<>();
        pq.add(new Node(destination - 1, 0));
        dist[destination - 1] = 0;
        
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(dist[now.id] < now.cost) continue;
            for(Node next : adj[now.id]) {
                int newDist = dist[now.id] + next.cost;
                if(newDist < dist[next.id]) {
                    dist[next.id] = newDist;
                    pq.add(new Node(next.id, newDist));
                }
            }
        }
        
        int[] ans = new int[sources.length];
        for(int i = 0; i < sources.length; i++){
            ans[i] = dist[sources[i] - 1] == Integer.MAX_VALUE ? -1 : dist[sources[i] - 1];
        }
        return ans;
    }
    static class Node implements Comparable<Node> {
        int id, cost;
        Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
//     public int[] solution(int n, int[][] roads, int[] sources, int destination) {
//         N = n;
        
//         dist = new int[N][N];
//         for(int i = 0; i < N; i++){
//             Arrays.fill(dist[i], Integer.MAX_VALUE); // 일단 길 없다고 표시
//             dist[i][i] = 0; // 자기자신 0
//         }
        
//         for(int[] road : roads) {
//             dist[road[0]-1][road[1]-1] = 1; // 길이 있는 곳에만 표시 
//             dist[road[1]-1][road[0]-1] = 1;
//         }
        
//         for(int i = 0; i < N; i++) {
//             for(int j = 0; j < N; j++) {
//                 for(int k = 0; k < N; k++) {
//                     if(dist[i][k] == Integer.MAX_VALUE || 
//                        dist[k][j] == Integer.MAX_VALUE) continue;
//                     if(dist[i][j] > dist[i][k] + dist[k][j]) { // i,j로 바로가기 > i,k + k,j 로 k거쳐 가기 
//                        dist[i][j] = dist[i][k] + dist[k][j]; 
//                     }
//                 }
//             }    
//         }
        
    
//         int[] ans = new int[sources.length];
//         for(int i = 0; i < sources.length; i++){
//             ans[i] = dist[sources[i]-1][destination-1] == Integer.MAX_VALUE ? -1 : dist[sources[i]-1][destination-1];
//         }
//         return ans;
//     }
}