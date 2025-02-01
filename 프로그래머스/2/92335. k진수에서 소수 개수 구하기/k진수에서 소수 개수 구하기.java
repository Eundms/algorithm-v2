import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String converted = convert(n, k);
        String[] arr = converted.split("[0]+");
        
        for(int i = 0; i < arr.length; i++) {
            boolean isPrime = checkIsPrime(arr[i]);
            answer += isPrime ? 1 : 0;
        }
        return answer;
    }
    
    static boolean checkIsPrime(String value) {
        long n = Long.parseLong(value);
        if(n <= 1)return false;
        if(n == 2 || n == 3)return true;
        for (long i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
  
    static String convert(int n, int k){
        if(n == 0) {return "0";}
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.insert(0, n % k);
            n /= k; 
        }
        return sb.toString();
    }
}