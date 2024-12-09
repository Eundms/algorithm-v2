import java.util.*;
class Solution {
    static int loser = 0;
    static int cnt = 0;
    static Set<String> prevWords;
   
    public int[] solution(int n, String[] words) throws Exception {
        prevWords = new HashSet<>();
        prevWords.add(words[0]);
        for(int w = 1; w < words.length; w++) {
            String prev = words[w-1];
            if(prev.charAt(prev.length()-1) == words[w].charAt(0)) {
                if(prevWords.contains(words[w])) {
                    loser = w % n + 1;
                    cnt = (w + 1) / n + ((w+1)%n == 0? 0 : 1);
                    break;
                } else {
                    prevWords.add(words[w]);
                }
            } else {
                loser = w % n + 1;
                cnt = (w + 1) / n +  ((w+1)%n == 0? 0 : 1);
                break;
            }
        }
        if(loser == 0) {
            return new int[]{0, 0};
        }
        return new int[]{loser, cnt};
    }
}