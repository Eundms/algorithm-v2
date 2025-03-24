import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static String str;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		N = str.length();
		if (str.charAt(0) == '0') {
			System.out.println(0);
			return;
		}
		int[] dp = new int[N + 1];// i번째 수까지 고려했을 때 가능한 해석의 수
		dp[0] = 1; // 빈 문자열 해석 1개
		dp[1] = 1; // 첫글자 1개
		for (int i = 2; i <= N; i++) {
			// 한자리 또는 두자리
			char one = str.charAt(i - 1);
			int twoLen = Integer.parseInt(str.substring(i - 2, i));

			if (one != '0') {
				dp[i] = (dp[i] + dp[i - 1]) % 1000000;
			}
			if (twoLen >= 10 && twoLen <= 26) {
				dp[i] = (dp[i] + dp[i - 2]) % 1000000;
			}
		}
		System.out.print(dp[N] % 1000000);
	}

}
