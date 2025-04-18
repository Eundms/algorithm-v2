import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T; // 지폐의 금액
	static int K; // 동전의 가지수
	// 동전의 금액 pi와 개수 ni
	static int[] pi;
	static int[] ni;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 목표 값
		K = Integer.parseInt(br.readLine()); // 동전의 가지수

		pi = new int[K]; // 동전의 금액
		ni = new int[K]; // 개수
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			pi[k] = Integer.parseInt(st.nextToken());
			ni[k] = Integer.parseInt(st.nextToken());
		}

		// i번째 종류까지 고려했을 때 T원
		int[] dp = new int[T + 1];
		dp[0] = 1; // 0원 만드는 경우 항상 1개
		for (int i = 0; i < K; i++) { // i번째 종류 동전 사용
			int[] next = new int[T + 1];
			for (int t = 0; t <= T; t++) { // t원 만드는 경우
				for (int c = 0; c <= ni[i]; c++) {
					if (t - pi[i] * c >= 0) {
						next[t] += dp[t - pi[i] * c];
					}
				}
			}
			dp = next;
		}

		System.out.println(dp[T]);
	}

	// ni종류의 동전을 사용해서, 어떤 금액을 만들 수 있는가 dp[금액]
	static void back(int value, int id) {
		if (value == 0) {
			res += 1;
			return;
		}
		for (int c = 0; c <= pi[id]; c++) {
			if (value - pi[id] * c >= 0) {
				back(value - pi[id] * c, id + 1);
			}
		}
	}

}
