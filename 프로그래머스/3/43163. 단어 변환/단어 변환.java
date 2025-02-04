import java.util.*;
class Solution {
    static Set<String> visited;
    static Set<String> dict;
    static String TARGET;
    static int answer = Integer.MAX_VALUE;
    public int solution(String begin, String target, String[] words) { // begin -> target : 가장 짧은 변환 과정 
        TARGET = target;

        dict = new HashSet<>();
        for(String word : words) {
            dict.add(word);
        }
        
        visited = new HashSet<>();
        back(begin,0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    static void back(String str, int cnt) {
       if(str.equals(TARGET)) {
           answer = Math.min(answer,cnt);
           return;
       }
        for(int i = 0; i < str.length(); i++){
            for(int a = 0; a < 25; a ++){
                String next = str.substring(0, i) +(char)('a' + a) + str.substring(i+1, str.length());
                if(visited.contains(next)) {
                    continue;
                }
                if(dict.contains(next)) {
                    visited.add(next);
                    back(next, cnt + 1);
                    visited.remove(next);
                }
                
            }
        }
    }
}