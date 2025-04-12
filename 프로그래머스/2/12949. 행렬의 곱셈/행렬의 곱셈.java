class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = new int[arr1.length][arr2[0].length];
        int sum = 0;

        for (int row1 = 0; row1 < arr1.length; row1++) {
            for (int col2 = 0; col2 < arr2[0].length; col2++) {
                sum = 0;
                for (int row2 = 0; row2 < arr2.length; row2++) {
                    sum += arr1[row1][row2] * arr2[row2][col2];
                }
                answer[row1][col2] = sum;
            }
        }
        return answer;
    }
}