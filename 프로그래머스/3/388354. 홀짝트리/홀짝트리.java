import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static Map<Integer, List<Integer>> trees = new HashMap<>();
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2];
    
        for(int node : nodes) {
            trees.put(node, new ArrayList<>());
        }
        
        for(int[] edge : edges) {
            trees.get(edge[0]).add(edge[1]);
            trees.get(edge[1]).add(edge[0]);
        }
        
        visited = new boolean[1000001];
        // 홀짝 트리 : 홀수노드, 짝수노드 
        for(int node : nodes) {
            if(!visited[node] && checkHolZzak(node, -1)) {
                answer[0] += 1;
            }
        }
        
        visited = new boolean[1000001];
        // 역홀짝 트리 : 역홀수노드, 역짝수 노드 
        // -> [홀짝 트리 개수, 역홀짝 트리 개수]
        for(int node : nodes) {
            if(!visited[node] && checkReverseHolZzak(node, -1)) {
                answer[1] += 1;
            } 
        }
        
        return answer;
    }
        
    // 홀수노드 : 번호(홀수), 자식노드개수(홀수)
    // 짝수노드 : 번호(짝수), 자식노드개수(짝수)

    static boolean checkHolZzak(int node, int parent) {
        int childrenCnt = trees.get(node).size() - 1; // 연결 관계 수 (부모 연결 + 자식연결 - 부모연결)  
        if(parent == -1) {
            childrenCnt +=1;
        }
        if(node % 2 == childrenCnt % 2) {
            visited[node] = true;
            for(int child : trees.get(node)) {
                if(child == parent)continue;
                if(!checkHolZzak(child, node)) {
                    visited[node] = false;
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    // 역홀수 노드 : 번호(홀수), 자식노드개수(짝수)
    // 역짝수 노드 : 번호(짝수), 자식노드개수(홀수)
        static boolean checkReverseHolZzak(int node, int parent) {
        int childrenCnt = trees.get(node).size()-1; // 연결 관계 수 (부모 연결 + 자식연결 - 부모연결)  
        if(parent == -1) {
            childrenCnt +=1;
        }
        if(node % 2 != childrenCnt % 2) {
            visited[node] = true;
            for(int child : trees.get(node)) {
                if(child == parent)continue;
                if(!checkReverseHolZzak(child, node)) {
                    visited[node] = false;
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}