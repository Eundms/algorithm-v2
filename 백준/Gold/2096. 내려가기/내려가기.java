import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] box;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		box = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] min = new int[N][3];
		for (int i = 0; i < N; i++) {
			Arrays.fill(min[i], Integer.MAX_VALUE);
			if (i == 0) {
				for (int j = 0; j < 3; j++) {
					min[i][j] = box[i][j];
				}
			}
		}

		int[][] max = new int[N][3];
		for (int i = 0; i < N; i++) {
			Arrays.fill(max[i], Integer.MIN_VALUE);
			if (i == 0) {
				for (int j = 0; j < 3; j++) {
					max[i][j] = box[i][j];
				}
			}
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					min[i][j] = Math.min(min[i - 1][j], min[i - 1][j + 1]) + box[i][j];
					max[i][j] = Math.max(max[i - 1][j], max[i - 1][j + 1]) + box[i][j];

				} else if (j == 1) {
					min[i][j] = Math.min(Math.min(min[i - 1][j], min[i - 1][j - 1]), min[i - 1][j + 1]) + box[i][j];
					max[i][j] = Math.max(Math.max(max[i - 1][j], max[i - 1][j - 1]), max[i - 1][j + 1]) + box[i][j];

				} else {
					min[i][j] = Math.min(min[i - 1][j], min[i - 1][j - 1]) + box[i][j];
					max[i][j] = Math.max(max[i - 1][j], max[i - 1][j - 1]) + box[i][j];
				}
			}
		}

		int minScore = Integer.MAX_VALUE, maxScore = Integer.MIN_VALUE;
		for (int i = 0; i < 3; i++) {
			minScore = Math.min(minScore, min[N - 1][i]);
			maxScore = Math.max(maxScore, max[N - 1][i]);
		}
		System.out.println(maxScore + " " + minScore);
	}

}