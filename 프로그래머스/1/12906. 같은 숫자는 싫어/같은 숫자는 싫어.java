import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        ans.add(arr[0]);
        while(j < arr.length) {
            if(arr[i] == arr[j]) {
                j += 1;
            }else {
                i = j;
                ans.add(arr[i]);
            }
        }

        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}