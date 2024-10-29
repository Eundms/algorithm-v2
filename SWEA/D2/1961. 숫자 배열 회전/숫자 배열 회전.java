import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N;
	static int[][] box;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			N = Integer.parseInt(br.readLine());
			box = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					box[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			StringBuilder sb = new StringBuilder();

			int[][] a = rotate(box);
			// print(a);
			box = copy(a);
			int[][] b = rotate(box);
			// print(b);
			box = copy(b);
			int[][] c = rotate(box);
			// print(c);
			for (int k = 0; k < N; k++) {
				for (int m = 0; m < N; m++) {
					sb.append(a[k][m]);
				}
				sb.append(" ");
				for (int m = 0; m < N; m++) {
					sb.append(b[k][m]);
				}
				sb.append(" ");
				for (int m = 0; m < N; m++) {
					sb.append(c[k][m]);
				}
				if (k != N - 1) {
					sb.append("\n");

				}
			}
			System.out.println("#" + test);
			System.out.println(sb.toString());
		}
	}

	static void print(int[][] box) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(box[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	static int[][] rotate(int[][] box) {
		int[][] next = new int[N][N];
		for (int i = 0; i < box.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				next[j][N - i - 1] = box[i][j];
			}
		}
		return next;
	}

	static int[][] copy(int[][] box) {
		int[][] e = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				e[i][j] = box[i][j];
			}
		}
		return e;
	}
}