import java.util.*;
class Solution {
    static List<Node>[] adj;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        adj = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++) {
            adj[i] = new ArrayList<>();
        }
        
        Set<Integer> sans = new HashSet<>();
        for(int i = 0; i < summits.length; i++) {
            sans.add(summits[i]);
        }
        
        Set<Integer> gate = new HashSet<>();
        for(int i = 0; i < gates.length; i++) {
            gate.add(gates[i]);
        }
        
        
        for(int i = 0; i < paths.length; i++) {
            int x = paths[i][0];
            int y = paths[i][1];
            int w = paths[i][2];
            if(gate.contains(x) || sans.contains(y)) { // 단방향 통신로 
                adj[x].add(new Node(y,w));
            }else if(gate.contains(y) || sans.contains(x)) {
                adj[y].add(new Node(x,w));
            }else {
                adj[x].add(new Node(y, w));
                adj[y].add(new Node(x, w));        
            }
        }
        
        
       return dikstra(n, gates, sans); // 시작 지점 gates 에서 
        
    }
    static int[] dikstra(int n, int[] gates, Set<Integer> ends) {
        int[] sanIntensity = new int[n+1];
        Arrays.fill(sanIntensity, Integer.MAX_VALUE);
        
        Queue<Node> queue = new ArrayDeque<>();
        for(int i = 0; i < gates.length; i++) {
            queue.add(new Node(gates[i], 0)); // 모든 시작 지점에서부터 시작
            sanIntensity[gates[i]] = 0;
        }

        
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            if(sanIntensity[now.x] < now.cost) {
                continue;
            }
        
            for(Node next : adj[now.x]) {
                int intensity = Math.max(next.cost, sanIntensity[now.x]);
                if(sanIntensity[next.x] > intensity) {
                    sanIntensity[next.x] = intensity;
                    queue.add(new Node(next.x, intensity));
                }
            }
        }
        
        int sanId = 0, minIntensity = Integer.MAX_VALUE;
        
        List<Integer> summit = new ArrayList<>(ends);
        Collections.sort(summit);
        
        for(int s : summit) {
            if(sanIntensity[s] < minIntensity) {
                minIntensity = sanIntensity[s];
                sanId = s;
            }
        }
        return new int[]{sanId, minIntensity};
        
    }
    static class Node implements Comparable<Node>{
        int x, cost;
        Node(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}