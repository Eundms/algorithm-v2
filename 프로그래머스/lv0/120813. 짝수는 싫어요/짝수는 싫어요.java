import java.util.*;
class Solution {
    public int[] solution(int n) {
        int size = (n%2==1?1:0) + n/2;
        int[] item = new int[size ];
        int cnt = 0;
        for(int i = 1; i<=n; i++){
            if(i%2!=0){
                item[cnt++] = i;
            }
        }
   
        
        return item;
    }
}