import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
public class Main {
	static int N;
    static boolean[] check = new boolean[1000];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 1 ~ 100
		for(int value = 123; value < 1000; value++) {
			String str = Integer.toString(value);
			if(str.charAt(0)=='0'||str.charAt(1)=='0'||str.charAt(2)=='0')continue;
            if(str.charAt(0)==str.charAt(1) || str.charAt(0)==str.charAt(2) || str.charAt(1)==str.charAt(2)) continue;
            check[value] = true;
		}
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int req = Integer.parseInt(st.nextToken());
			int strike = Integer.parseInt(st.nextToken());
			int ball = Integer.parseInt(st.nextToken());
			for(int ans = 123; ans < 1000; ans++){
				if(!check[ans]){continue;}
	            int numStrike = 0;
	            int numBall = 0;
	            for(int idx = 0; idx < 3; idx++){
	            	char req_split = Integer.toString(req).charAt(idx);
	            	for(int idx2 = 0; idx2 < 3; idx2++){
	            		char ans_split = Integer.toString(ans).charAt(idx2);
	            		if(req_split == ans_split && idx == idx2) numStrike++;
	                    else if(req_split == ans_split && idx != idx2) numBall++;
	                 }
	            }
	            if(numStrike == strike && numBall == ball) check[ans] = true;
	            else check[ans] = false; 
	      }
		}
		int cnt = 0;
		for(int ans = 123; ans < 1000; ans++) {
			if(check[ans]) {
				cnt+=1;
			}
		}
		System.out.println(cnt);
	}
}