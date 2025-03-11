import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K; // N가지 종류 동전 -> 합이 K
	static int[] coins;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine()); // 코인 갯수
		}

		// 동전의 개수가 최소가 되도록!
		int[] dp = new int[K + 1]; // k원을 만드는 데 사용된 동전의 ㅅ ㅜ
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < N; i++) {
			if (coins[i] <= K) {
				dp[coins[i]] = 1;

			}

		}
		// dp[i] = dp[i-coins[n]] + 1;
		for (int i = 0; i <= K; i++) {
			for (int n = 0; n < N; n++) {
				if (i - coins[n] < 0)
					continue;
				if (dp[i - coins[n]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - coins[n]] + 1);

				}
			}
		}
		System.out.println(dp[K] == Integer.MAX_VALUE ? -1 : dp[K]);
	}

}