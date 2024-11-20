import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int N, M; // N x N, 하나의 집 비용 M
	static int[][] box; // 집이 있는 위치 1 , 나머지 0
	static int EMPTY = 0, WALL = 1;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				box[i][j] = line.charAt(j) - '0';
			}
		}
		bfs(0, 0, 0);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);

		}
	}

	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static void bfs(int sx, int sy, int crush) { // 벽 부셔도 됨 한개까지
		boolean[][][] visited = new boolean[N][M][2];
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { sx, sy, 1, 0 }); // 최단거리, 부신 벽 개수

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (now[0] == N - 1 && now[1] == M - 1) {
				answer = Math.min(now[2], answer);
			}
			for (int w = 0; w < 4; w++) {
				int nx = now[0] + way[w][0];
				int ny = now[1] + way[w][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M)
					continue;
				if (visited[nx][ny][now[3]]) {
					continue;
				}
				// 이동 가능
				if (box[nx][ny] == EMPTY) {
					visited[nx][ny][now[3]] = true;
					queue.add(new int[] { nx, ny, now[2] + 1, now[3] });
				} else if (box[nx][ny] == WALL) {
					// 이동 불가능
					if (now[3] == 0) { // 한번도 벽을 부순적 없음
						// 벽 부수고 이동
						visited[nx][ny][1] = true;
						queue.add(new int[] { nx, ny, now[2] + 1, 1 });
					}
				}
			}
		}
	}

}
