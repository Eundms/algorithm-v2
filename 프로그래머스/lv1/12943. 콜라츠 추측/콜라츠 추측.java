class Solution {
    public int solution(int num) {
        long x = num;
        boolean guess = true;
        int cnt = 0;
        while(true){
            if(x==1){
                return cnt;
            }
            if(cnt >= 500){
                guess = false;
                break;
            }
            
            x = x % 2 == 0 ? x / 2: x * 3 +1;
            
            cnt +=1;
            
        }
        if(!guess){
            return -1;
        }
        return cnt;
    }
}