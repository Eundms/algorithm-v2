class Solution {
    static int CONTINUE_TIME, OVERCOME_AMOUNT, ADD_OVERCOME_AMOUNT;
    // 시전시간(t), 초당 회복량(x), 추가회복량(y)
    static int MAX_HEALTH;
    public int solution(int[] bandage, int health, int[][] attacks) {
        CONTINUE_TIME = bandage[0];
        OVERCOME_AMOUNT = bandage[1];
        ADD_OVERCOME_AMOUNT = bandage[2];
        MAX_HEALTH = health;
        
        int notAttack = 0;
        for(int i = 0; i < attacks.length; i++) {
            int attackTime = attacks[i][0]; // 공격시간, 오름차순 정렬된 상태
            int damage = attacks[i][1]; // 피해량
            if(attackTime > notAttack) { 
                int continusTime = attackTime - 1 - notAttack;
                // System.out.print("연속"+continusTime);
                // System.out.println("회복량"+(OVERCOME_AMOUNT * continusTime 
                //                           + continusTime / CONTINUE_TIME * ADD_OVERCOME_AMOUNT));
                int prevHealth = Math.min(MAX_HEALTH, health + (OVERCOME_AMOUNT * continusTime 
                                          + continusTime / CONTINUE_TIME * ADD_OVERCOME_AMOUNT));
                // System.out.println("체력"+prevHealth); 
                int nextHealth =  prevHealth - damage;
                if(nextHealth <= 0) {
                    health = -1;
                    break;
                }
                health = nextHealth;
                
                notAttack = attackTime ;
            }
        }
        return health;
    }
}