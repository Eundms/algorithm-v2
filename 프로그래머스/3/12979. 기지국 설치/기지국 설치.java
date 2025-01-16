import java.util.*;
class Solution {
    // N : 아파트의 개수 / 200,000,000 이하의 자연수
    // stations : 현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 / 10,000 이하의 자연수
    // W : 전파의 도달 거리  
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int sIdx = 0;
        // 시작 끝 미리 정해두기
        // 너비 2 * w + 1 
        List<Node> nodes = new ArrayList<>();
        for(int i = 0; i < stations.length; i++) {
            int start = Math.max(1, stations[i] - w);
            int end = Math.min(stations[i] + w, n);
            nodes.add(new Node(start, end));
        }
        
        Collections.sort(nodes);
        
        System.out.println(nodes);
        int apt = 1;
        for(int i = 0; i < nodes.size(); i++) {
            Node node = nodes.get(i);
            if(node.start > apt){
              // 전파 세워야함
                int dist = node.start - apt;
                int buildCnt = build(dist, w);
                answer += buildCnt;
                apt = node.end;
            } 
        }
        if(apt < n) {
            answer += build(n - apt, w);
        }
        
        return answer;
    }
    static int build(int dist, int w) {
        return dist / (2 * w + 1) + (dist % (2 * w + 1) > 0 ? 1 : 0);
    }
    static class Node implements Comparable<Node>{
        int start, end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Node o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
        }
        @Override
        public String toString() {
            return ""+this.start+" "+this.end;
        }
    }
}