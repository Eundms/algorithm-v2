class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int sum = 0;
        String xStr = Integer.toString(x);
        for(int i = 0; i< xStr.length(); i++){
            sum += xStr.charAt(i)-'0';
        }
        if(x%sum==0){ // x 자릿수 합으로 x가 나눠져야함
            return true;
        }
        return false;
    }
}