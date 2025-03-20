import java.io.BufferedReader;
import java.io.FileInputStream;
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
	static int W, H; // 빌딩 지도 너비와 높이
	static char WALL = '#', EMPTY = '.', FIRE = '*';
	static int sx, sy;
	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static List<int[]> fires;

	// https://www.acmicpc.net/problem/5427
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
			for (int f = 0; f < fires.size(); f++) {
				spread.add(new int[] { fires.get(f)[0], fires.get(f)[1], 0 }); // 1초후부터 확산
				fireTime[fires.get(f)[0]][fires.get(f)[1]] = 0;
			}

			while (!spread.isEmpty()) {
				int[] now = spread.poll();

				for (int w = 0; w < 4; w++) {
					int nx = now[0] + way[w][0];
					int ny = now[1] + way[w][1];
					if (!inRange(nx, ny))
						continue;

					if (fireTime[nx][ny] == Long.MAX_VALUE && box[nx][ny] == EMPTY) {
						spread.add(new int[] { nx, ny, now[2] + 1 });
						fireTime[nx][ny] = now[2] + 1;
					}
				}
			}
			// printFireTime(fireTime);

			long time = movePerson(fireTime);
			if (time == Long.MAX_VALUE) {

				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(time);
			}
		}

	}

	static void printFireTime(int[][] fireTime) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print((fireTime[i][j] == Integer.MAX_VALUE ? -1 : fireTime[i][j]) + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	static long movePerson(long[][] fireTime) {
		boolean[][] visited = new boolean[H][W];
		Queue<int[]> move = new ArrayDeque<>();
		move.add(new int[] { sx, sy, 1 });
		visited[sx][sy] = true;

		while (!move.isEmpty()) {
			int[] now = move.poll();
			for (int w = 0; w < 4; w++) {
				int nx = now[0] + way[w][0];
				int ny = now[1] + way[w][1];
				if (!inRange(nx, ny)) {
					return now[2];
				}
				if (visited[nx][ny]) {
					continue;
				}
				if (box[nx][ny] == EMPTY && fireTime[nx][ny] > now[2]) { // 불이 옮겨진 칸, 이제 붙으려는 칸으로 이동 불가능
					visited[nx][ny] = true;
					move.add(new int[] { nx, ny, now[2] + 1 });
				}
			}
		}
		return Long.MAX_VALUE;
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}

}
