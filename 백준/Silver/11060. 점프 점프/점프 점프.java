import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N]; // i번째 칸까지 오는 최소 점프 횟수
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0; // 시작점은 점프가 필요 없음

		for (int i = 0; i < N; i++) {
			if (dp[i] == Integer.MAX_VALUE)
				continue;

			for (int jump = 1; jump <= arr[i]; jump++) {
				if (i + jump >= N)
					break;
				dp[i + jump] = Math.min(dp[i + jump], dp[i] + 1);
			}
		}

		System.out.println(dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1]);
	}
}
