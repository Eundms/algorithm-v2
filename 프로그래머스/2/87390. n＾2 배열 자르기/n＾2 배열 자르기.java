import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
     
        int[] answer = new int[(int)(right-left+1)];
        for(long x = left; x <= right; x++) {
            answer[(int)(x - left)] = (int) Math.max(x / n , x % n) + 1;
        }
        
        return answer;
    }
    
    static int[] copy(int[] arr, long left, long right) {
        int[] copyed = new int[(int)(right - left + 1)];
        for(int i = (int)left; i <= (int)right; i++) {
            copyed[i-(int)left] = arr[i];
        }
        return copyed;
    }
}