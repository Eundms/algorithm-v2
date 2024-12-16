import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int H, W, X, Y;
	static int[][] box;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken()); // 크기 H x W
		W = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		box = new int[H + X][W + Y];
		for (int i = 0; i < H + X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W + Y; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] ans = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				ans[i][j] = box[i][j];
			}
		}

		for (int i = X; i < H; i++) {
			for (int j = Y; j < W; j++) {
				ans[i][j] = box[i][j] - ans[i - X][j - Y];

			}

		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}

}
