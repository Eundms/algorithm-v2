import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; // 수열A의 크기
	static int[] arr; // 수열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] LIS = new int[N]; // 증가하는 부분 수열
		Arrays.fill(LIS, 1);
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) { // 앞의 모든 원소와 비교해서 부분 수열을 만듦 N^2
				if (arr[i] > arr[j]) {
					LIS[i] = Math.max(LIS[j] + 1, LIS[i]);
				}
			}
		}

		int[] LDS = new int[N]; // 감소하는 부분 수열
		Arrays.fill(LDS, 1);
		for (int i = N - 2; i >= 0; i--) {
			for (int j = i + 1; j < N; j++) { // 뒤의 모든 원소와 비교해서 부분 수열을 만듦 N^2
				if (arr[i] > arr[j]) {// 뒤의 값 j가 더 작아야 함 (감소)
					LDS[i] = Math.max(LDS[j] + 1, LDS[i]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, LIS[i] + LDS[i] - 1);
		}
		System.out.println(max);

	}
}
