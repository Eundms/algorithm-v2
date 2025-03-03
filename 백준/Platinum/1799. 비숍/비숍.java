import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] box;
	static List<int[]> blacks;
	static List<int[]> whites;

	static boolean[] twoFour;
	static boolean[] oneThree;

	static int EMPTY = 0, BISOP = 2;
	static int maxBisopCnt;
	static int maxBlack, maxWhite;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		blacks = new ArrayList<>();
		whites = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		box = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) { // 비숍을 놓을 수 있는 곳
					if ((i + j) % 2 == 0) {
						blacks.add(new int[] { i, j });
					} else {
						whites.add(new int[] { i, j });
					}
				}
				// 비숍을 놓을 수 없는 곳 : 0
			}
		}

		twoFour = new boolean[N * 2];
		oneThree = new boolean[N * 2];

		back(blacks, 0, 0);
		maxBlack = maxBisopCnt;

		maxBisopCnt = 0;
		back(whites, 0, 0);
		maxWhite = maxBisopCnt;

		System.out.println(maxBlack + maxWhite); // 독립적인 사건이므로

	}

	static void back(List<int[]> positions, int idx, int cnt) {
		if (idx >= positions.size()) {
			maxBisopCnt = Math.max(maxBisopCnt, cnt);
			return;
		}
		int x = positions.get(idx)[0];
		int y = positions.get(idx)[1];

		if (!twoFour[x - y + N] && !oneThree[x + y]) { // 현재 위치에 비숍을 놓는 경우
			twoFour[x - y + N] = true;
			oneThree[x + y] = true;

			back(positions, idx + 1, cnt + 1);

			twoFour[x - y + N] = false;
			oneThree[x + y] = false;
		}
		back(positions, idx + 1, cnt); // 비숍을 놓지않는 경우
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
