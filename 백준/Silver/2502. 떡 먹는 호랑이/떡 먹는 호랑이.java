import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken()); // 할머니가 넘어온 날
		int k = Integer.parseInt(st.nextToken()); // 그날 호랑이에게 준 떡의 개수
		// dp[i] = dp[i-1] + dp[i-2];
		// dp[d](k) = dp[d-1] + dp[d-2];
		dp = new int[d + 1];
		for (int i = 1; i <= k / 2; i++) {
			for (int j = i; j <= k; j++) {
				if (k == cal(d, i, j)) {
					System.out.println(i);
					System.out.println(j);
					return;
				}
			}
		}
	}

	static int cal(int day, int a, int b) {
		dp[1] = a;
		dp[2] = b;
		for (int i = 3; i <= day; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[day];
	}

}
