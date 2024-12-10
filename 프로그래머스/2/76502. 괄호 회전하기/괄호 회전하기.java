import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        // }]()[{ 
        // [)(]
        // }}}
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            boolean isAnswer = true;
            for (int len = 0; len < s.length(); len++) {
                int idx = (i + len) % s.length();
                char current = s.charAt(idx);
                if(current == '(' || current == '{' || current == '[') {
                    stack.push(current);                
                } else {
                    if(stack.isEmpty()) {
                        isAnswer = false;
                        break;
                    }
                    char prev = stack.pop();
                    if(!(current == ')' && prev == '(' || 
                      current == '}' && prev == '{' ||
                      current == ']' && prev == '[')) {
                        isAnswer = false;
                        break;
                    } 
                }
            }
            if(!stack.isEmpty()) {
                isAnswer = false;
            }
            if(isAnswer) {
                answer += 1;
            }
        }
        return answer;
    }
}