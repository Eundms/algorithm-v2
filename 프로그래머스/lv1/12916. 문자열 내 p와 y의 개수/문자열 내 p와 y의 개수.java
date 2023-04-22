class Solution {
    boolean solution(String s) {
        System.out.println(s.toLowerCase());
        // p 개수 == y 개수 true , false
        int pCnt = 0, yCnt = 0;
        for(int i = 0; i< s.length(); i++){
            char item = s.charAt(i);
            if('P'==Character.toUpperCase(item)){
                pCnt += 1;
            }else if('Y'==Character.toUpperCase(item)){
                yCnt += 1;
            }
        }
        if(pCnt == yCnt){
            return true;
        }
        return false;
    }
}