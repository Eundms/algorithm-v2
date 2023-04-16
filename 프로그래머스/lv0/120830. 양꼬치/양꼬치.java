class Solution {
    public int solution(int n, int k) {
        int cnt = n/10;
        int answer = n* 12000 + k * 2000 -  cnt * 2000;
        return answer;
    }
}