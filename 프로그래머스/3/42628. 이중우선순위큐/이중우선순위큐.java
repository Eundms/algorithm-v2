import java.util.*;
class Solution {
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
    public int[] solution(String[] operations) {
        int[] answer = {};
        for(int i = 0; i < operations.length; i++){
            StringTokenizer st = new StringTokenizer(operations[i]);
            String command = st.nextToken();
            int data = Integer.parseInt(st.nextToken());
            if(command.equals("I")) {
                min.add(data);
                max.add(data);
            } else if(command.equals("D")) { // 큐에서 최댓값 삭제
                if(min.isEmpty())continue;
                if(data == 1){
                    int x = max.poll();
                    min.remove(x);
                }else {
                    int x= min.poll();
                    max.remove(x);
                }
            }
        }
        
        int a = 0, b = 0;
        if(!min.isEmpty()){
            a = min.peek();
            b = max.peek();
        }
        return new int[]{b,a};
    }
}