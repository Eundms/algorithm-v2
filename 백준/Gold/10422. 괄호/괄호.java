import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int T; // 테스트케이스의 개수
	// 괄호 문자열의 길이 나타내는 L
	// 길이 L 문자열 중 올바른 괄호를 가지는 문자열의 개수
	static int L;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		long[] dp = new long[5000 + 1];
		dp[0] = 1;
		dp[2] = 1;
		for (int i = 2; i <= 2500; i++) {
			for (int j = 0; j < i; j++) {
				dp[i * 2] += dp[j * 2] * dp[(i - 1 - j) * 2];
				dp[i * 2] %= 1_000_000_007;
			}
		}

		for (int test = 1; test <= T; test++) {
			L = Integer.parseInt(br.readLine());
			if (L % 2 != 0) {
				System.out.println(0);
				continue;
			}
			// 일단 짝수어야 함

			// L = 6 가정
			// ((()))
			// (()+())
			// ()+(()) (())+() dp[2] * dp[4]
			// ()+()+()

			System.out.println(dp[L] % 1_000_000_007);
		}
	}

}
