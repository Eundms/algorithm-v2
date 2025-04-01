import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (col(i)) {
				cnt += 1;
			}
			if (row(i)) {
				cnt += 1;
			}
		}
		System.out.println(cnt);

	}

	static boolean col(int c) {
		boolean[] isCline = new boolean[N];
		for (int r = 0; r < N - 1; r++) {
			int diff = map[r][c] - map[r + 1][c];
			if (diff == 0)
				continue;
			if (diff == 1) {
				for (int d = 1; d <= L; d++) {
					if (r + d >= N || map[r + d][c] != map[r][c] - 1) {
						return false;
					}
					if (isCline[r + d])
						return false;
					isCline[r + d] = true;
				}
			} else if (diff == -1) {
				for (int d = 0; d < L; d++) {
					if (r - d < 0 || map[r - d][c] != map[r][c]) {
						return false;
					}
					if (isCline[r - d])
						return false;
					isCline[r - d] = true;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	static boolean row(int r) {
		boolean[] isCline = new boolean[N];
		for (int c = 0; c < N - 1; c++) {
			int diff = map[r][c] - map[r][c + 1];
			if (diff == 0)
				continue;
			if (diff == 1) {
				for (int d = 1; d <= L; d++) {
					if (c + d >= N || map[r][c + d] != map[r][c] - 1) {
						return false;
					}
					if (isCline[c + d])
						return false;
					isCline[c + d] = true;
				}
			} else if (diff == -1) {
				for (int d = 0; d < L; d++) {
					if (c - d < 0 || map[r][c - d] != map[r][c]) {
						return false;
					}
					if (isCline[c - d])
						return false;
					isCline[c - d] = true;
				}
			} else {
				return false;
			}
		}
		return true;
	}

}