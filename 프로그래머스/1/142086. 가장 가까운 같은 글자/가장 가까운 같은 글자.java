import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, -1);
        Map<Character, Integer> near = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(near.containsKey(arr[i])) {
                answer[i] = i - near.get(arr[i]);
            }
            near.put(arr[i], i);
        }
        return answer;
    }
}