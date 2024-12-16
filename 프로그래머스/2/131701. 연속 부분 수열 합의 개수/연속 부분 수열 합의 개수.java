import java.util.*;
class Solution {
    static int N;
    public int solution(int[] elements) {
        N = elements.length;
        Set<Integer> set = new HashSet<>();
        for(int s = 0; s < N; s++) {
            for(int l = 0; l < N; l++) {
                int sum = 0;
                for(int i = s; i <= s + l; i++) {
                    sum += elements[i%N];
                }
                set.add(sum);
            }
        }
        return set.size();
    }
}