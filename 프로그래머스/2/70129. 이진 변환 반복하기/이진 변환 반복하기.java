import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String s) throws Exception{
        int[] ans = new int[2];
        
            while(!s.equals("1")){
                int x = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i)-'0'==1){
                      x+=1;          
                }else {
                    ans[1]+=1;
                }
            }
        
            List<Integer> arr = new ArrayList<>();
            while(x > 1) {
	            arr.add(x % 2);
	            x /= 2;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("1");
            for(int i = arr.size()-1; i>=0; i--){
                sb.append(arr.get(i));
            }
            s = sb.toString();
            ans[0]+=1;
            }
        
        
        return ans;
    }
}