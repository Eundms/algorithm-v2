import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; // 수열A의 크기
	static int[] arr; // 수열
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[N]; // i번째 요소를 포함하는 LIS의 길이
		Arrays.fill(dp, 1);
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}

		System.out.println(Arrays.stream(dp).max().getAsInt());

	}
}
