class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                int c = ( s.charAt(i) + n - 'a') % 26 + 'a'; 
                answer.append((char)(c));
            } else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z' ) {
                int c = (s.charAt(i) + n - 'A') % 26 + 'A'; 
                answer.append((char)(c));  
            }  else {
                answer.append(s.charAt(i));
            }
        }
        return answer.toString();
    }
}