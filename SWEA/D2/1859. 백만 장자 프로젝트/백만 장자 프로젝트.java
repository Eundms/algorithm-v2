import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N;
	static long[] price;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			price = new long[N];
			for (int i = 0; i < N; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			long max = price[N - 1];
			// 오른쪽에서 가장 max 인 값 찾으면 됨
			long sum = 0;

			for (int i = N - 1; i >= 0; i--) {
				max = Math.max(price[i], max);
				sum += (max - price[i] > 0) ? max - price[i] : 0;

			}

			System.out.println("#" + test + " " + sum);
		}
	}

}