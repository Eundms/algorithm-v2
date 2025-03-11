import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] box;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		box = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dfs(i, j);
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		System.out.println(max);
	}

	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int dfs(int i, int j) {
		if (dp[i][j] != 0) {
			return dp[i][j];
		}
		dp[i][j] = 1;
		for (int w = 0; w < 4; w++) {
			int nx = i + way[w][0];
			int ny = j + way[w][1];
			if (!inRange(nx, ny) || box[nx][ny] <= box[i][j])
				continue;
			dp[i][j] = Math.max(dp[i][j], dfs(nx, ny) + 1);

		}

		return dp[i][j];
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
}