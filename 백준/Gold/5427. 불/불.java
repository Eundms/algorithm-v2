import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static char[][] box;
	static int W, H;
	static char WALL = '#', EMPTY = '.', FIRE = '*';
	static int sx, sy;
	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static List<int[]> fires;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			fires = new ArrayList<>();
			box = new char[H][W];

			for (int h = 0; h < H; h++) {
				String str = br.readLine();
				for (int w = 0; w < W; w++) {
					box[h][w] = str.charAt(w);
					if (box[h][w] == '@') {
						sx = h;
						sy = w;
						box[h][w] = EMPTY;
					} else if (box[h][w] == FIRE) {
						fires.add(new int[] { h, w });
					}
				}
			}

			long[][] fireTime = new long[H][W];
			for (int h = 0; h < H; h++) {
				Arrays.fill(fireTime[h], Long.MAX_VALUE);
			}

			Queue<int[]> spread = new ArrayDeque<>();
			for (int[] fire : fires) {
				spread.add(new int[] { fire[0], fire[1], 0 });
				fireTime[fire[0]][fire[1]] = 0;
			}

			while (!spread.isEmpty()) {
				int[] now = spread.poll();

				for (int w = 0; w < 4; w++) {
					int nx = now[0] + way[w][0];
					int ny = now[1] + way[w][1];

					if (!inRange(nx, ny) || fireTime[nx][ny] != Long.MAX_VALUE || box[nx][ny] != EMPTY) {
						continue;
					}

					fireTime[nx][ny] = now[2] + 1;
					spread.add(new int[] { nx, ny, now[2] + 1 });
				}
			}

			long result = movePerson(fireTime);
			System.out.println(result == Long.MAX_VALUE ? "IMPOSSIBLE" : result);
		}
	}

	static long movePerson(long[][] fireTime) {
		Queue<int[]> move = new ArrayDeque<>();
		boolean[][] visited = new boolean[H][W];
		move.add(new int[] { sx, sy, 0 });
		visited[sx][sy] = true;

		while (!move.isEmpty()) {
			int[] now = move.poll();
			int x = now[0], y = now[1], time = now[2];

			for (int w = 0; w < 4; w++) {
				int nx = x + way[w][0];
				int ny = y + way[w][1];

				if (!inRange(nx, ny))
					return time + 1;
				if (visited[nx][ny] || box[nx][ny] != EMPTY)
					continue;
				if (fireTime[nx][ny] <= time + 1)
					continue;

				visited[nx][ny] = true;
				move.add(new int[] { nx, ny, time + 1 });
			}
		}
		return Long.MAX_VALUE;
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}
}
