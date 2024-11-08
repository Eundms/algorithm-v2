import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int W, H;
	static int[][] box;
	static int LAND = 1, WATER = 0;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0) {
				break;
			}
			box = new int[H][W];
			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					box[h][w] = Integer.parseInt(st.nextToken());
				}
			}
			int cnt = 0;
			visited = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {

					if (box[i][j] == LAND && !visited[i][j]) {
						bfs(i, j);
						cnt += 1;
					}
				}
			}
			System.out.println(cnt);
		}

	}

	static int[][] way = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 },
			{ 1, 1 } };

	static void bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int w = 0; w < 8; w++) {
				int nx = way[w][0] + now[0];
				int ny = way[w][1] + now[1];
				if (nx < 0 || nx >= H || ny < 0 || ny >= W || visited[nx][ny])
					continue;
				visited[nx][ny] = true;
				if (box[nx][ny] == LAND) {
					queue.add(new int[] { nx, ny });
				}
			}

		}
	}

}