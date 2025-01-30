import java.util.*;
class Solution {
    static int[][] user;
    static int[] emoticon; 
    static int M;
    static int[] discountPercentage = new int[]{10, 20, 30, 40};
    static int[] percentage;
    static int maxPlusCnt = 0, maxMoney = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        user = users;
        emoticon = emoticons;
        M = emoticons.length;
        percentage = new int[M];
        // 1. 가입자 늘리기
        // 2. 판매액 늘리기
        // n명의 카카오톡 사용자들, 이모티콘 m개 할인 판매 
        // 할인율 10, 20, 30, 40 중 하나로 설정
        permutation(0);
        // 1) 일정 비율 이상 할인하는 이모티콘 모두 구매
        // 2) 구매 비용의 합 >= 일정 가격 : 이모티콘 플러스 서비스
        
        
        return new int[]{maxPlusCnt, maxMoney};
    }
    static void permutation(int cnt) {
        if(cnt == M){
            int[] res = calculate(percentage);
            if(maxPlusCnt < res[0]) {
                maxPlusCnt  = res[0];  
                maxMoney = res[1];
            } else if(maxPlusCnt == res[0]) {
                maxMoney  = Math.max(maxMoney, res[1]);
            } 
            return;
        }
        for(int value : discountPercentage) {
            percentage[cnt] = value;
            permutation(cnt + 1);
        }
    }
    
    static int[] calculate(int[] percentage) {
        int emoticonPlus = 0;
        int allPayed = 0;
        
        for(int[] u : user) {
            int minPercentage = u[0];
            int minPrice = u[1];
            int payed = 0;
            for(int e = 0; e < emoticon.length; e++) {
                if(percentage[e] >= minPercentage) { // 일정 비율 이상 => 구매
                    payed += emoticon[e] * (100 - percentage[e]) / 100;
                }
            }
            if(payed >= minPrice) { // 이모티콘 구매 비용의 합 => 일정 가격 이상 => 구매 취소
                payed = 0;
                emoticonPlus += 1;
            }
            allPayed += payed;
        }
        //System.out.println(Arrays.toString(percentage));
        //System.out.println(emoticonPlus+" "+allPayed);
        return new int[]{emoticonPlus, allPayed};
    }
}