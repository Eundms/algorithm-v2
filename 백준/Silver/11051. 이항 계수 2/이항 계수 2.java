import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[][] comb;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		comb = new long[N+1][K+1];
		// 서로 다른 N개 중 K개 선택
		// nCk = n-1Ck-1 + n-1Ck
		
		for(int n = 1; n <= N ; n++) {
			for(int k= 0; k <= K; k++) {
				if(k==0) {
					comb[n][k] = 1;					
				}else if(n==k) {
					comb[n][k] = 1;
				}else {
					comb[n][k] = (comb[n-1][k-1] + comb[n-1][k])%10007;
				}
			}
		}
		
		System.out.println(comb[N][K]%10007);
	}

}
