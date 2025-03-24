import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] T, P;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N + 2];
		P = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			// 상담하지 않고 넘어가기 (다음 날에도 현재 최대 수익 유지)
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);

			// 상담 가능한 경우
			if (i + T[i] <= N + 1) {
				dp[i + T[i]] = Math.max(dp[i + T[i]], dp[i] + P[i]);
			}
		}

		System.out.println(dp[N + 1]);
	}
}
