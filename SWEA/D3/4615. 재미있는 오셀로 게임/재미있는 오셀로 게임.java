import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	static int T; // tc 개수
	static int N, M; // 보드의 한 변의 길이, 플레이어가 돌을 놓는 횟수
	static int[][] box;
	static int[][] way = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			box = new int[N][N];
			box[N / 2 - 1][N / 2 - 1] = 2; // W
			box[N / 2 - 1][N / 2 + 1 - 1] = 1; // B
			box[N / 2 + 1 - 1][N / 2 + 1 - 1] = 2; // W
			box[N / 2 + 1 - 1][N / 2 - 1] = 1; // B
			for (int m = 0; m < M; m++) {

				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;
				int value = Integer.parseInt(st.nextToken());

				box[x][y] = value;

				for (int w = 0; w < 8; w++) {

					List<int[]> rItems = new ArrayList<>();
					int a = x, b = y;
					while (true) {
						int nx = a + way[w][0];
						int ny = b + way[w][1];

						if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
							break;
						}
						if (box[nx][ny] == 0) {
							break;
						} else if (box[nx][ny] == value) {
							reverse(rItems, value);
							break;
						} else {
							rItems.add(new int[] { nx, ny });
						}
						a = nx;
						b = ny;
					}
				}

			}
			int white = 0;
			int black = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					white += box[i][j] == 2 ? 1 : 0;
					black += box[i][j] == 1 ? 1 : 0;
				}
			}
			System.out.println("#" + test + " " + black + " " + white);
		}
	}

	static void reverse(List<int[]> rItems, int value) {
		for (int i = 0; i < rItems.size(); i++) {
			int[] item = rItems.get(i);
			box[item[0]][item[1]] = value;
		}
	}

}