class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(Math.max(n,m), Math.min(n,m));
        answer[1] = lcm(Math.max(n,m), Math.min(n,m));
        
        return answer;
    }
    // 유클레드호제법 
    static int gcd(int a, int b){
        int r = a;
        while(r != 0) {
            r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    static int lcm(int a, int b){
        return (a*b) / gcd(a, b);
    }
}