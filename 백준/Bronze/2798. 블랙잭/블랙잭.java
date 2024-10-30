import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // (카드의 개수) (외칠 숫자)
	static int[] box;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		box = new int[N];
		for (int n = 0; n < N; n++) {
			box[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(box);
		int value = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			if (M < box[i]) {
				break;
			}
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int sum = box[i] + box[j] + box[k];
					if (sum <= M) {
						if (M - sum < diff) {
							diff = M - sum;
							value = sum;
						}
					}
				}
			}
		}
		System.out.println(value);
	}

}