import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        // 오른쪽 -> 왼쪽 : 자기보다 큰 숫자들만 남겨놓기 
        for(int i = numbers.length - 1; i >=0 ; i--) {
            while(!stack.isEmpty() && stack.peek() <= numbers[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                answer[i] = stack.peek();
            }
            stack.add(numbers[i]);
        }
        return answer;
    }
}