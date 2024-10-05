
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int K;
	static int[] box;
	static int[] ans;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    while(true) {
		    StringTokenizer st = new StringTokenizer(br.readLine());

		    K = Integer.parseInt(st.nextToken()); // 정수의 개수
		    if(K == 0) {break;}

		    box = new int[K];		    
		    for(int k = 0 ; k < K; k++) {
		    	box[k] = Integer.parseInt(st.nextToken());
		    }
		    
		    ans = new int[6];
		    lotto(0, 0);
		    System.out.println();
	    }
	 
	}
	static void lotto(int cnt, int idx) {
		if(cnt == 6) {
			for(int i  = 0; i < 6; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int kIdx = idx ; kIdx < K; kIdx++) {
			ans[cnt] = box[kIdx];
			lotto(cnt + 1, kIdx + 1);
		}
		
	}
	

}