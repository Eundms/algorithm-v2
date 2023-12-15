import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
class Main { 	
	static int N,M;
	static int[][] box;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개의 줄
		M = Integer.parseInt(st.nextToken()); // M개의 정수
		box = new int[N+1][M+1];
		for(int i = 1; i <= N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 0 0 0 0 
		// 1 1 1 1
		int[][] dp = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				dp[i][j] = box[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
			}
		}
	
		StringBuilder sb = new StringBuilder();
		int K = Integer.parseInt(br.readLine());
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int sum = dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1];
			sb.append(sum+"\n");
		}
		System.out.println(sb);
	}
	static void print(int[][] dp) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

}


 