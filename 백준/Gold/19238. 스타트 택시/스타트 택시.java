import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, fuel; // 라운드의수
	static int[][] box;
	static int[][] personToId;
	static int[] car; // 운전 시작하는 칸 번호, 열 번호
	static int[][] routes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		box = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		car = new int[2];
		car[0] = Integer.parseInt(st.nextToken()) - 1;
		car[1] = Integer.parseInt(st.nextToken()) - 1;

		personToId = new int[N][N];
		routes = new int[M + 1][5];
		for (int m = 1; m <= M; m++) { // 승객의 출발지와 행과 번호, 목적지의 행과 열 번호
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;
			routes[m][0] = sx;
			routes[m][1] = sy;
			routes[m][2] = ex;
			routes[m][3] = ey;
			routes[m][4] = bfs(sx, sy, ex, ey); // 번호
			personToId[sx][sy] = m;

		}
		// i, j -> id ?
		while (true) {
			int[] person = findNear();
			if (person[0] == -1 || routes[person[0]][4] == Integer.MAX_VALUE) {
				break;
			}
			if (fuel - person[1] < 0) {
				break;
			}

			fuel -= person[1];// 승객 위치로 이동
			car[0] = routes[person[0]][0];
			car[1] = routes[person[0]][1];

			if (fuel < routes[person[0]][4]) { // 이동하는 도중에 연료가 바닥나면 이동에 실패
				break;
			}

			fuel += routes[person[0]][4]; // 거리 * 2 충전
			car[0] = routes[person[0]][2];
			car[1] = routes[person[0]][3];

		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (personToId[i][j] > 0) {
					System.out.println(-1);
					return;
				}
			}
		}

		System.out.println(fuel);

	}

	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	static int bfs(int sx, int sy, int ex, int ey) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new ArrayDeque<>();
		visited[sx][sy] = true;
		queue.add(new int[] { sx, sy, 0 });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (now[0] == ex && now[1] == ey) {
				return now[2];
			}
			for (int w = 0; w < 4; w++) {
				int nx = now[0] + way[w][0];
				int ny = now[1] + way[w][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
					continue;
				if (box[nx][ny] == 1)
					continue;
				visited[nx][ny] = true;
				queue.add(new int[] { nx, ny, now[2] + 1 });
			}
		}
		return Integer.MAX_VALUE;
	}

	static int[] findNear() {
		boolean[][] visited = new boolean[N][N];

		int minDist = Integer.MAX_VALUE, rowId = N, colId = N, id = -1;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { car[0], car[1], 0 });
		visited[car[0]][car[1]] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (personToId[now[0]][now[1]] > 0) {
				if (minDist > now[2] || minDist == now[2] && (rowId > now[0] || rowId == now[0] && colId > now[1])) {
					minDist = now[2];
					id = personToId[now[0]][now[1]];
					rowId = now[0];
					colId = now[1];
				}
			}
			for (int w = 0; w < 4; w++) {
				int nx = now[0] + way[w][0];
				int ny = now[1] + way[w][1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
					continue;
				}
				if (box[nx][ny] == 1)
					continue;
				visited[nx][ny] = true;
				queue.add(new int[] { nx, ny, now[2] + 1 });
			}
		}
		if (id > 0) {
			personToId[rowId][colId] = -1;
		}
		return new int[] { id, minDist };

	}

}
