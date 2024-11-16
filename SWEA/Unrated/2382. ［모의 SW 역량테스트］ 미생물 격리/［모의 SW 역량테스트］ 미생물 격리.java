import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N, M, K; // 셀의 개수, 격리 시간, 미생물 군집의 개수
	// 상 하 좌 우
	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<int[]> items;
	static List<Item>[][] box;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 셀의 개수
			M = Integer.parseInt(st.nextToken()); // 격리 시간

			box = create();
			items = new ArrayList<>();
			K = Integer.parseInt(st.nextToken()); // 미생물 군집의 수
			for (int k = 1; k <= K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // 세로
				int y = Integer.parseInt(st.nextToken()); // 가로
				int cnt = Integer.parseInt(st.nextToken()); // 수
				int dir = Integer.parseInt(st.nextToken()) - 1; // 방향
				items.add(new int[] { x, y });
				box[x][y].add(new Item(cnt, way[dir][0], way[dir][1]));
			}

			for (int m = 0; m < M; m++) {
				box = move(); // items move
				zipAndDistroy(); // 절반 죽고, 이동 방향 반대로 바뀜
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (Item item : box[i][j]) {
						cnt += item.cnt;
					}
				}
			}
			System.out.println("#" + t + " " + cnt);
		}

	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(box[i][j].size());
			}
			System.out.println();
		}
		System.out.println();
	}

	static List<Item>[][] move() {
		List<Item>[][] next = create();
		for (int i = 0; i < items.size(); i++) {
			int[] now = items.get(i); // 여기서 이동
			int nx = now[0] + box[now[0]][now[1]].get(0).dx;
			int ny = now[1] + box[now[0]][now[1]].get(0).dy;
			next[nx][ny].addAll(box[now[0]][now[1]]);
		}
		return next;
	}

	static void zipAndDistroy() {
		items = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				List<Item> cur = new ArrayList<>();
				// 하나로 만들기 위한 작업
				int allCnt = 0;
				int dx = 0, dy = 0;
				int maxCnt = 0;
				for (int c = 0; c < box[i][j].size(); c++) {
					Item item = box[i][j].get(c);
					if (maxCnt < item.cnt) {
						maxCnt = item.cnt;
						dx = item.dx;
						dy = item.dy;
					}
					allCnt += item.cnt;
				}

				// 경계에 있다면 처리
				if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
					allCnt /= 2;
					dx = -1 * dx;
					dy = -1 * dy;
				}

				if (allCnt > 0) {
					Item zipped = new Item(allCnt, dx, dy);
					cur.add(zipped);
					items.add(new int[] { i, j });
				}

				box[i][j] = cur;

			}
		}
	}

	static List<Item>[][] create() {
		List<Item>[][] next = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				next[i][j] = new ArrayList<>();
			}
		}
		return next;
	}

	static class Item {
		int cnt, dx, dy;

		Item(int cnt, int dx, int dy) {
			this.cnt = cnt;
			this.dx = dx;
			this.dy = dy;
		}

	}

}
