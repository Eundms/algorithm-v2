import java.util.*;
class Solution {
    // N : 아파트의 개수 / 200,000,000 이하의 자연수
    // stations : 현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 / 10,000 이하의 자연수
    // W : 전파의 도달 거리  
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int apt = 1;
        // 시작 끝 미리 정해두기
        // 너비 2 * w + 1 
        for(int i = 0; i < stations.length; i++) {
            int start = stations[i] - w;
            int end = stations[i] + w;
            if (apt < start) {
                answer += build(start - apt, w);
            }  
            apt = end + 1;
        }
        
        if(apt <= n) {
            answer += build(n-apt+1, w);
        }
        
 
        return answer;
    }
    static int build(int dist, int w) {
        return dist / (2 * w + 1) + (dist % (2 * w + 1) > 0 ? 1 : 0);
    }

}