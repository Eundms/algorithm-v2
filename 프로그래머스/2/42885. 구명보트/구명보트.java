import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        // 최대 2명씩 밖에 탈 수 없음 -> 무거운 친구랑 가벼운 친구 같이 태우는 게 효율적
        int i = 0, j = people.length-1;
        while(i<j){
            if(people[i] + people[j]<=limit){
                i+=1;
                j-=1;
                answer+=1;
            }else {
                j-=1;
                answer+=1;
            }
                
        }
        if(i== j){
            answer +=1;
        }
        return answer;
    }
}