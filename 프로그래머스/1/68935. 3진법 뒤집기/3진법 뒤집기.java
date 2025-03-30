class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = Integer.toString(n, 3);         // 10진수 → 3진수 문자열
        StringBuilder sb = new StringBuilder(str);   // 문자열을 StringBuilder로 감싸고
        sb.reverse();                                // 뒤집기
       answer = Integer.parseInt(sb.toString(), 3);         // 10진수 → 3진수 문자열

        return answer;
    }
}