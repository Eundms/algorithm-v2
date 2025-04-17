class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxLeft = 0, maxRight = 0;
        for(int[] size : sizes) {
            if(size[0] < size[1]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
            maxLeft = Math.max(maxLeft, size[0]);
            maxRight = Math.max(maxRight, size[1]);
        }
        
        return maxLeft * maxRight;
    }
}