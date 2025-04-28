class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long zero = 0;

        for (int x = -r2; x <= r2; x++) {
            long x2 = (long)x * x;
            
            if (x2 >= (long)r1 * r1 && x2 <= (long)r2 * r2) {
                zero++;
            }
            
            long maxY2 = (long)r2 * r2 - x2;
            long minY2 = (long)r1 * r1 - x2;
            
            if (maxY2 < 0) continue; // 아예 해당 x에서 불가능한 경우
            int maxY = (int) Math.floor(Math.sqrt(maxY2));
            int minY = 0;
            if (minY2 > 0) {
                minY = (int) Math.ceil(Math.sqrt(minY2));
            }
            
            if (maxY >= minY) {
                answer += (maxY - minY + 1);
            }
        }
        
        return answer * 2 - zero;
    }
}
