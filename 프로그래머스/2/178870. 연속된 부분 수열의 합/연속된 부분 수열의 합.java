class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {-1, -1};
        int N = sequence.length;
        int sum = sequence[0];
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while(right < N) {
            if(sum == k) {
                if(min > right - left + 1) {
                    min = right - left + 1;
                    answer[0] = left;
                    answer[1] = right;
                }
                sum -= sequence[left];
                left ++;
            } else if(sum > k) {
                sum -= sequence[left];
                left++;
            } else { // sum < k
                if (++right < sequence.length) {
                    sum += sequence[right];
                }
            }
        }
        return answer;
    }
}