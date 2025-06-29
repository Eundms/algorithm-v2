import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		long minSum = Long.MAX_VALUE;
		long ans1 = 0, ans2 = 0, ans3 = 0;

		for (int i = 0; i < N - 2; i++) {
			int left = i + 1;
			int right = N - 1;

			while (left < right) {
				long sum = arr[i] + arr[left] + arr[right];

				if (Math.abs(sum) < minSum) {
					minSum = Math.abs(sum);
					ans1 = arr[i];
					ans2 = arr[left];
					ans3 = arr[right];
				}

				if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		System.out.println(ans1 + " " + ans2 + " " + ans3);
	}
}
