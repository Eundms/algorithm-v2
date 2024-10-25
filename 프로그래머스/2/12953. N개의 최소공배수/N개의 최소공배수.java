class Solution {
    public int solution(int[] arr) {
        if(arr.length == 1){
            return arr[0];
        }
        int prevLcm = lcm(arr[0], arr[1]);
        for(int i = 2 ; i < arr.length; i++){
            prevLcm = lcm(prevLcm,arr[i]);
        }
        
        return prevLcm;
    }
    static int lcm(int a, int b){
        return a * b / gcd(a,b);
    }
    static int gcd(int a, int b){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        while(b!=0){
            int n = a%b;
            a = b;
            b = n;
        }
        return a;
    }
}
// lcm  = a * b / gcd(a,b)
