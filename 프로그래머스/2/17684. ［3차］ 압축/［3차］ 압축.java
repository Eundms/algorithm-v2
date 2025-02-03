import java.util.*;
import java.io.*;
class Solution {
    static Map<String, Integer> dict;
    
    static {
        dict = new HashMap<>();
        for(int i = 0; i < 26; i++){
            dict.put(""+(char)('A'+i), i+1);        
        }
    }
    
    public int[] solution(String msg) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < msg.length()){
            int j = i+1;
            while(j <= msg.length()) {
                String maxLenStr = msg.substring(i, j);

                if(!dict.keySet().contains(maxLenStr)) {
                    dict.put(maxLenStr, dict.size()+1);
                    break;
                }
                j+=1;
            }
            ans.add(dict.get(msg.substring(i,j-1)));
            i = j-1;
        }    
        return ans.stream().mapToInt(x->x).toArray();
    }
}