import java.util.*;
class Solution {
    static int N;
    public int[] solution(int[] prices) { // 주식가격이 담긴 배열
        N = prices.length;
        int[] answer = new int[N];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.add(i);
        }
        
        while (!stack.isEmpty()) {
            int prev = stack.pop();
            answer[prev] = N - prev - 1;
        }
        
        return answer;
    }
}