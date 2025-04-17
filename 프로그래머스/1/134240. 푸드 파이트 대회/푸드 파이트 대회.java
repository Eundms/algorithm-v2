class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        // 왼쪽 -> 오른쪽
        // 왼쪽 <- 오른쪽
        // 물 먼저 먹는 선수가 승리 
        // 먹는 음식의 종류와 양이 같아야 함
        // 음식을 먹는 순서도 같아야 함 
        // 칼로리가 낮은 음식부터 먹어서 음식 더 잘 먹을 수 있도록 
        // 대회의 조건을 고려하지 않고 음식을 주문하여 몇 개의 음식은 대회에 사용하지 못하게 됨
        for(int i = 1; i < food.length; i++){
            int x = food[i];
            for(int c = 0; c < x/2; c++){
                answer.append(i);
            }
        }
        return answer.toString() +"0"+answer.reverse().toString();
    }
}