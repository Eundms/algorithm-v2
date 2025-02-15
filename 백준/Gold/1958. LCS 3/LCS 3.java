import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, M, K;
	static int[][][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		String str3 = br.readLine();

		N = str1.length();
		M = str2.length();
		K = str3.length();

		dp = new int[N + 1][M + 1][K + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				for (int k = 1; k <= K; k++) {
					if (str1.charAt(i - 1) == str2.charAt(j - 1) && str2.charAt(j - 1) == str3.charAt(k - 1)) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(Math.max(dp[i - 1][j][k], dp[i][j - 1][k]), dp[i][j][k - 1]);
					}

				}
			}
		}

		System.out.println(dp[N][M][K]);
	}

}