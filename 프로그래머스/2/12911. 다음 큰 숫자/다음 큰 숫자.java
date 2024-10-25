import java.io.*;
import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        
        int cnt = 0;
        String str = Integer.toBinaryString(n);
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='1'){
                cnt += 1;
            }
        }
        
        for(int x = n+1; ;x++){
            String a = Integer.toBinaryString(x);
            int acnt = 0;
            for(int i = 0; i < a.length(); i++){
            if(a.charAt(i)=='1'){
                acnt += 1;
            }
            
            }
            if(acnt == cnt){
                return x;
            }
        }
        
 
    }
}