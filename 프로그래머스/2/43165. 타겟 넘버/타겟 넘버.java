import java.io.*;
import java.util.*;
class Solution {
    static int res;
    public int solution(int[] numbers, int target) throws Exception {
        dfs(0, 0, numbers, target);
        return res;
    }
    static void dfs(int sum, int cnt, int[] numbers, int target) {
        if(cnt == numbers.length){
            if(sum == target) {
                res+=1;
            }
            return;
        }
        
        dfs(sum + numbers[cnt], cnt + 1, numbers, target);
        dfs(sum - numbers[cnt], cnt + 1, numbers, target);
    }
}