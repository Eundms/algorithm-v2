import java.util.*;
class Solution {
    static List<Item> items;
    public int solution(int[][] targets) {
        int answer = 0;
        // A나라 : X축에 평행한 직선 형태의 모양 (S,E)
        // B나라 : Y축에 평행 
        items = new ArrayList<>();
        for(int i = 0 ; i < targets.length; i++) {
            items.add(new Item(targets[i][0], targets[i][1]));
        }
        Collections.sort(items);
        // System.out.println(items);
        int cnt = 1;
        int lastIdx = items.get(0).y;
        for(int i = 1; i < items.size(); i++) {
            if(items.get(i).x >= lastIdx) { // 겹쳐있지않다 
                cnt += 1;
                lastIdx = items.get(i).y;
            }
            // System.out.println(lastIdx);
        }
        return cnt;
    }
    static class Item implements Comparable<Item>{
        int x, y;
        Item(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Item o) {
            return this.y - o.y;
        }
        @Override
        public String toString() {
            return "(" + this.x + "," + this.y + ") ";
        }
    }
}