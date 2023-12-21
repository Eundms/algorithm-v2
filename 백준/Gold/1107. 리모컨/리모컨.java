import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;
public class Main {
	static int N; // 이동하려는 채널
	static int M; // 고장난 버튼의 개수
	static boolean[] broken;
	static int minCnt;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 이동하려고 하는 채널
        M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수 
        
        broken = new boolean[10];
        if(M>0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int m = 0; m < M; m++) {
            	broken[Integer.parseInt(st.nextToken())] = true;
            }        	
        }
        int result = Math.abs(N - 100);
        for(int value = 0; value <= 999999; value++) {
        	String str = ""+value;
        	int len = str.length();
        	boolean isBreak = false;
        	for(int j = 0; j < len; j++) {
        		if(broken[str.charAt(j)-'0']) {
        			isBreak = true;
        			break;
        		}
        	}
        	if(!isBreak) {
        	      int min = Math.abs(N - value) + len; 
                  result = Math.min(min, result);
        	}
        }
        System.out.println(result);
    }
}

 