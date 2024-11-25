import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N개의 정수로 이루어진 수열
		M = Integer.parseInt(st.nextToken()); // 차이가 M이상이면서 제일 작은 경우
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		// 두 수 골랐을 때, 차이가 M이상이면서 제일 작은 경우
		int i = 0, j = 0;
		int ans = Integer.MAX_VALUE;
		while (j < N) {
			if (arr[j] - arr[i] < M) {
				j += 1;
			} else if (arr[j] - arr[i] == M) {
				ans = M;
				break;
			} else {
				ans = Math.min(ans, arr[j] - arr[i]);
				i += 1;
			}
		}
		System.out.println(ans);
	}

}
