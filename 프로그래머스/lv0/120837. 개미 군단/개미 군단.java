class Solution {
    public int solution(int hp) {
        int answer = 0;
        // 장군 개미 5의 공격력
        // 병정 개미 3의 공격력
        // 일 개미 1의 공격력
        int cntFive = hp / 5;
        hp = hp - cntFive * 5;
        
        int cntThree = hp / 3;
        hp = hp - cntThree * 3;  
            
        int cntOne = hp;
        return cntFive + cntThree + cntOne;
    }
}