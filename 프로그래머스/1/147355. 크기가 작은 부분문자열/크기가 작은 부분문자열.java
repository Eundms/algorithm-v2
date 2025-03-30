class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        if(t.length() >= p.length()){
            long b = Long.parseLong(p);
            for(int i = 0; i <= t.length() - p.length(); i++){
                String str = t.substring(i, i + p.length());
                long a = Long.parseLong(str);
                if(a <= b) {
                    answer += 1;
                }
            }
            
        }
        return answer;
    }
}