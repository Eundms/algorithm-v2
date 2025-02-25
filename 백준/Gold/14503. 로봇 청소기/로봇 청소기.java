import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int r, c, d;
	// 북(0) 동(1) 남(2) 서(3)
	static int[][] way = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[][] box;
	static int WALL = 1, EMPTY = 0, CLEANED = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 방의 크기
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		// 북 남 서 동
		while (true) {
			if (box[r][c] == EMPTY) {
				cnt += 1;
				box[r][c] = CLEANED;
			}

			boolean clearNear = false;
			for (int w = 0; w < 4; w++) { // 주변 4칸 중 청소되지 않은 빈칸이 없는 경우
				int nx = r + way[w][0];
				int ny = c + way[w][1];
				if (!inRange(nx, ny)) {
					continue;
				}
				if (box[nx][ny] == EMPTY) {
					clearNear = true;
				}
			}

			if (!clearNear) { // 4칸 중 청소되지 않은 빈칸이 없는 경우
				int nx = r - way[d][0];
				int ny = c - way[d][1];
				if (!inRange(nx, ny) || box[nx][ny] == WALL) {
					break;
				}
				r = nx;
				c = ny;
			} else {
				d = (d + 3) % 4; // 반 시계 방향으로 90도 회전
				int nx = r + way[d][0];
				int ny = c + way[d][1];
				if (!inRange(nx, ny)) {
					continue;
				}
				if (box[nx][ny] == EMPTY) {
					r = nx;
					c = ny;
				}
			}
		}

		System.out.println(cnt);

	}

	static boolean isEmpty(int x, int y) {
		return box[x][y] != WALL;
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
