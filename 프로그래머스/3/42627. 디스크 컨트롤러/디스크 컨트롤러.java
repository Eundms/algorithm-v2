import java.util.*;
class Solution {
    static int JOB_SIZE;
    public int solution(int[][] jobs) { // 요청_시각 작업_소요_시간
        JOB_SIZE = jobs.length;
        List<Item> arr = new ArrayList<>();
        for(int i = 0; i < jobs.length; i++) {
            arr.add(new Item(i, jobs[i][0], jobs[i][1]));
        }
        Collections.sort(arr, Comparator.comparingInt(x -> x.reqTime)); // 요청 빨리 온 순서대로 
        
        PriorityQueue<Item> pq = new PriorityQueue<>();
        int jIdx = 0;
        int curTime = 0;
        int sumReturnTime = 0;
        
        int finishedCnt = 0;
        while(true) {
            if(finishedCnt == JOB_SIZE)break;
            while(jIdx < JOB_SIZE && arr.get(jIdx).reqTime <= curTime) {
                pq.add(arr.get(jIdx));
                jIdx++;
            }
      
            if(!pq.isEmpty()){
                Item cur = pq.poll();
                int returnTime = cur.cost + curTime - cur.reqTime ;
                sumReturnTime += returnTime;
                curTime += cur.cost;     
                finishedCnt += 1;
            }else {
                curTime += 1;
            }
        }
        return sumReturnTime/JOB_SIZE;
    }
    static class Item implements Comparable<Item>{
        int id;
        int reqTime;
        int cost;
        Item(int id, int reqTime, int cost) {
            this.id = id;
            this.reqTime = reqTime;
            this.cost = cost;
        }
        @Override
         public int compareTo(Item o) { 
             if (this.cost == o.cost) {
                 if (this.reqTime == o.reqTime) {
                    return this.id - o.id;                     
                 }
                 return this.reqTime - o.reqTime;
             }
             return this.cost - o.cost;
         }
        
        @Override
        public String toString() {
            return this.id +" "+ this.reqTime+" "+ this.cost;
        }
    }
}