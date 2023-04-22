import java.util.*;
class Solution {
    public long solution(long n) {
        
        String str = Long.toString(n);
        Integer[] items = new Integer[str.length()];
        for(int i = 0; i< str.length() ; i++){
            items[i] = str.charAt(i)-'0';
        }        
        Arrays.sort(items,Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            sb.append(items[i]);
        }
        return Long.parseLong(sb.toString());
    }
}