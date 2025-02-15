import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, M;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();

		N = str1.length();
		M = str2.length();

		dp = new int[N + 1][M + 1];
		// dp[i][j] = case(같은 경우, 다른 경우)
		// 1) 같은 경우 : dp[i-1][j-1] + 1
		// 2) 다른 경우 : Math.max(dp[i-1][j] , dp[i][j-1])
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		StringBuilder sb = new StringBuilder();

		int i = N, j = M;
		while (i > 0 && j > 0) {
			if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // LCS에 포함
				sb.append(str1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i - 1][j] >= dp[i][j - 1]) { // 더 큰 방향으로 이동
				i--;
			} else {
				j--;
			}
		}
		System.out.println(dp[N][M]);
		System.out.println(sb.reverse().toString());
	}

}