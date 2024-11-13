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
		int[] right = new int[N];
		left[0] = box[0];
		right[N - 1] = box[N - 1];
		for (int i = 1; i < N; i++) {
			left[i] = left[i - 1] + box[i];
			right[N - 1 - i] = right[N - i] + box[N - 1 - i];
		}

		int max = 0;
		for (int i = 1; i < N - 1; i++) {
			max = Math.max(max, left[i] - left[0] + right[i] - right[N - 1]);
			max = Math.max(max, left[N - 1] + left[N - 1] - left[0] - box[i] - left[i]);
			max = Math.max(max, right[0] + right[0] - right[N - 1] - box[N - 1 - i] - right[N - 1 - i]);
		}
		System.out.println(max);

	}

}
