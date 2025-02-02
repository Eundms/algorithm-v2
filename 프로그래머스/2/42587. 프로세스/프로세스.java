import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Item> pq = new PriorityQueue<>();
        Deque<Item> queue = new ArrayDeque<>();
        for(int i = 0; i < priorities.length; i++) {
            Item o = new Item(i, priorities[i]);
            queue.add(o);
            pq.add(o);
        }
        
        while(true){
            Item current = queue.pollFirst();
            if(current.value < pq.peek().value) { // 어떤게 우선순위가 높은지 판단하는 것 
                queue.addLast(current);
            } else {
                answer += 1;
                if(current.i == location)break;
                pq.poll();
            }
        }
        return answer;
    }
    static class Item implements Comparable<Item>{
        int i; // location
        int value; 
        Item(int i , int value) {
            this.i = i;
            this.value = value;
        }
        @Override
        public int compareTo(Item o){
            return o.value - this.value ;
        }
    }
}