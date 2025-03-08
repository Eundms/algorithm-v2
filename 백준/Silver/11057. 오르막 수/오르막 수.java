import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 자리가 오름차순을 이루는 수, 인접한 수가 같아도 오름차순으로 침
		// dp[i][j] // i번째 자리까지 고려하여 j(0-9중)를 택했을 때 갯수
		// dp[i][j] dp[i-1][0...j-1] 개수 다 더하기

		long[][] dp = new long[N + 1][10];
		for (int j = 0; j <= 9; j++) {
			dp[1][j] = 1;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++) {
					dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
				}
			}
		}
		long sum = 0;
		for (long x : dp[N]) {
			sum = (sum + x) % 10007;
		}
		System.out.println(sum % 10007);
	}
}
