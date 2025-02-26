import java.io.*;
import java.util.*;
class Solution {
    static int N, K;
    static int max;
    static Stack<Character> stack;
    static char[] arr;
    public String solution(String number, int k) {
        arr = number.toCharArray();
        stack = new Stack<>();
        for(char a : arr){
            while(!stack.isEmpty() && a > stack.peek() && k-- > 0) {
                stack.pop();
            }
            stack.push(a);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String ans = sb.reverse().toString();
        if(k > 0) {
            ans = ans.substring(0, ans.length() - k);
        }
        return ans;
    }

}