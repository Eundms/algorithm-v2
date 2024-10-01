import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
    for (int t = 1; t <= T; t++) {
    	int N = Integer.parseInt(br.readLine()); // 돌아가야할 학생들의 수 
		int[] cnt = new int[200];

    	for(int n = 0; n < N; n++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int startIdx = Integer.parseInt(st.nextToken());
    		int endIdx = Integer.parseInt(st.nextToken());
    		if(startIdx > endIdx) {
        		int temp = startIdx;
        		startIdx = endIdx;
        		endIdx = temp;
    		}
    		for(int i = (startIdx-1)/2; i <(endIdx-1)/2+1;i++) {
    			cnt[i] += 1;
    		}
    	}
    	int max = 0;
    	for(int i = 0; i < 200;i++) {
    		max = Math.max(max,  cnt[i]);
    	}
    	System.out.println("#"+t+" "+max); // 필요한 시간
    }
  
    
  }  
  

}
