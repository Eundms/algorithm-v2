import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int[] coins;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine()); // 동전의 가지수
			coins = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				coins[n] = Integer.parseInt(st.nextToken());
			}
			M = Integer.parseInt(br.readLine()); // 구해야할 금액
			int[] dp = new int[M + 1];
			dp[0] = 1;
			for (int coin : coins) {
				for (int m = coin; m <= M; m++) {
					dp[m] += dp[m - coin];// dp[m] += dp[m-coins[n]]// 금액m을 만드는 가지수
				}
			}
			System.out.println(dp[M]);
		}
	}
}
