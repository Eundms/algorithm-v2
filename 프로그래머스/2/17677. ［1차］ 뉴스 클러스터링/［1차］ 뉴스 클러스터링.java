import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String,Integer> setOne = createSet(str1);
        Map<String, Integer> setTwo = createSet(str2);
        
        Set<String> added = new HashSet<>();
        added.addAll(setOne.keySet());
        added.addAll(setTwo.keySet());

        int x = 0;
        for(String a : added) {
            x += Math.max(setOne.getOrDefault(a, 0),setTwo.getOrDefault(a, 0));
        }   
        
        Set<String> oneKeys = new HashSet<>(setOne.keySet()); 
        oneKeys.retainAll(setTwo.keySet());

        int y = 0;
        for(String o : oneKeys) {
            y += Math.min(setOne.getOrDefault(o, 0), setTwo.getOrDefault(o, 0));
        }
        
        // addAll : 합집합, retainAll : 교집합
        if (x == 0) {
            answer = 65536;
        } else {
            answer = 65536 * y / x;
        }
        
        return answer;
    }
    static boolean isAlphabet(char a) {
        return a >= 'a'&& a <= 'z' || a >= 'A' && a <= 'Z';
    }
    // 영문자 2글자씩 
    static Map<String, Integer> createSet(String str){
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i+1);
            if (isAlphabet(a) && isAlphabet(b)) {
                String value = ""+a+b;
                map.put(value.toLowerCase(), map.getOrDefault(value.toLowerCase(), 0) + 1);
            }
        }
        return map;
    }
}