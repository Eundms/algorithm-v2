import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 숫자를 0부터 n까지 사용 가능
		// 마지막으로 더한 숫자를 0에서 N까지 바꾸어 나가며 점화식 구하기
        
		// dp[k][n] = dp[k-1][n] + dp[k][n-1];
		dp = new int[K + 1][N + 1];
		for (int k = 0; k < K + 1; k++) {
			Arrays.fill(dp[k], 1);
		}
		int MOD = 1_000_000_000;
		for (int k = 2; k <= K; k++) {
			for (int n = 1; n <= N; n++) {
				dp[k][n] = (dp[k - 1][n] + dp[k][n - 1]) % MOD;
			}
		}
		System.out.println(dp[K][N]);
	}

}
