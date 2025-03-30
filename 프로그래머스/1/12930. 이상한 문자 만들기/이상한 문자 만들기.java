class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') {
                cnt = 0;
                sb.append(' ');
                continue;
            }
                String ss = "" +s.charAt(i);
            if(cnt%2 == 0){
                sb.append(ss.toUpperCase());                  
            } else {
                sb.append(ss.toLowerCase());
            }
            cnt += 1;
        }
        return sb.toString();
    }
}