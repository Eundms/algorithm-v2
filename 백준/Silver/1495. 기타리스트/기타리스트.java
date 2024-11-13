import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, S, M;
	static int[] volume;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 0 - M 볼륨

		// volumne : i번째 곡을 연주하기 전에 바꿀 수 있는 볼륨
		st = new StringTokenizer(br.readLine());
		volume = new int[N]; // N곡의 개수
		for (int i = 0; i < N; i++) {
			volume[i] = Integer.parseInt(st.nextToken());
		}
		// i번째 곡까지 연주했을 때 최댓값
		// 볼륨 = dp[i-1] + V[i]
		// 볼륨2 = dp[i-1] - V[i]
		// dp[i][볼륨] = 가능
		dp = new int[N + 1][M + 1]; // 곡의 개수, 볼륨
		dp[0][S] = 1;
		for (int i = 1; i <= N; i++) { // n번째 곡
			for (int j = 0; j <= M; j++) { // 볼륨
				if (dp[i - 1][j] != 0) {
					int vUp = j + volume[i - 1];
					int vDown = j - volume[i - 1];
					if (inRange(vUp)) {
						dp[i][vUp] = 1;
					}
					if (inRange(vDown)) {
						dp[i][vDown] = 1;
					}
				}
			}
		}
		int ans = -1;
		for (int i = M; i >= 0; i--) {
			if (dp[N][i] == 1) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}

	static boolean inRange(int volume) {
		return volume >= 0 && volume <= M;
	}

}
