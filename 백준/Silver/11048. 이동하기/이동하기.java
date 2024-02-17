import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {
	static int N,M;
	static int[][] dp;
	static int[][] candy;
	public static void main(String[] args)throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		candy = new int[N+1][M+1]; // (1,1) ~ (N,M)
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				candy[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 가장 윗방 (1,1) => 가장 오른쪽 방 (N,M)
		dp = new int[N+1][M+1];
		for(int i = 1; i <= N ; i++) {
			for(int j = 1; j <= M; j++) {
				
				dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + candy[i][j];
			}
		}
		System.out.println(dp[N][M]);
		
	}
}


 

 