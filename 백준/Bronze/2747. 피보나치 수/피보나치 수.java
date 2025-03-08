import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// 0번째 피보나치 수 0, 1번째 피보나치 수 1, .. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다
		dp = new int[N + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[N]);
	}
}
