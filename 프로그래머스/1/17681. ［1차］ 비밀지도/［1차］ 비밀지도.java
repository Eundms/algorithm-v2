import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            int[] one = decode(n, arr1[i]);
            int[] two = decode(n, arr2[i]);
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                sb.append((one[j] == 1 || two[j] == 1)? '#' : ' ');
            }
            answer[i] = sb.toString();
        }
        
        return answer;
    }
    static int[] decode(int n, int value) {
        int[] res = new int[n];
        int i = 0;
        while(value>0) {
            res[n-1-i] = value%2;
            value /= 2;
            i+=1;
        }
        if(value==1) {
            res[i] = 1;
        }
        return res;
    }
}