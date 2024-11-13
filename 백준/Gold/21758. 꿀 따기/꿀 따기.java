import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] box;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		box = new int[N];
		for (int i = 0; i < N; i++) {
			box[i] = Integer.parseInt(st.nextToken());
		}

		int[] left = new int[N];
		for (int i = 0; i < N; i++) {
			if (i == 0) {
				left[i] = box[i];
			} else {
				left[i] = box[i] + left[i - 1];
			}
		}

		int[] right = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			if (i == N - 1) {
				right[i] = box[i];
			} else {
				right[i] = box[i] + right[i + 1];
			}
		}
		int max = 0;
		for (int h = 0; h < N; h++) { // honey
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (h == i || h == j || i == j)
						continue;
					int sum = 0;
					if (h < i) { // h i
						sum += right[h] - right[i];
					} else { // i h
						sum += left[h] - left[i];
					}

					if (h < j) { // h j
						sum += right[h] - right[j];
					} else { // j h
						sum += left[h] - left[j];
					}

					if (h < i && h < j) {
						if (i < j) { // h < i < j
							sum -= box[i];
						} else {
							sum -= box[j];

						}
					}
					if (h > i && h > j) {
						if (i < j) { // h < i < j
							sum -= box[j];
						} else {
							sum -= box[i];
						}
					}
					max = Math.max(max, sum);
				}
			}
		}

		System.out.println(max);

	}

}
