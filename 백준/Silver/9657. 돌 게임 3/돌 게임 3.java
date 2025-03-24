import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		// int[] dp = new int[N+1];
		// dp[i] = dp[i-1] + dp[i-3] + dp[i-4] // i개 남았을 때 이기는 사람 true , false
		// 하나라도 false이면 dp[i] = true
		boolean[] dp = new boolean[N + 5];
		dp[1] = true;
		dp[2] = false;
		dp[3] = true;
		dp[4] = true;
		for (int i = 5; i <= N; i++) {
			dp[i] = !dp[i - 1] || !dp[i - 3] || !dp[i - 4];
		}
		System.out.println(dp[N] ? "SK" : "CY");
	}
}
