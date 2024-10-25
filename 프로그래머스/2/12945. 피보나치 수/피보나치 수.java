class Solution {
    public int solution(int n) {
        int[] x = new int[n+1];
        x[1] = 1;
        for(int a = 2; a <= n; a++){
            x[a] = (x[a-1] + x[a-2])%1234567;
        }
        return x[n];
    }
    static int fibo(int n){
        if(n <= 1){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }
}