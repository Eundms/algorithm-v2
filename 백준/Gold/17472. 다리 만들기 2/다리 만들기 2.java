import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 세로 크기, 가로 크기
	static int[][] box;
	static boolean[][] visited;
	static int[][] dist; // from to
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 1. 섬에 번호 부여
		int color = 1;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j])
					continue;
				if (box[i][j] == 1) {
					bfs(i, j, color);
					color++;
				}
			}
		}
		dist = new int[color][color];
		for (int i = 0; i < color; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			dist[i][i] = 0;
		}
		// 2. 다리 만들기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] > 0) {
					for (int w = 0; w < 4; w++) {
						makeBridge(i, j, w);
					}
				}
			}
		}
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 1; i < color; i++) {
			for (int j = i + 1; j < color; j++) {
				if (dist[i][j] == Integer.MAX_VALUE)
					continue;
				pq.add(new Node(i, j, dist[i][j]));
			}
		}

		parent = new int[color];
		for (int i = 0; i < color; i++) {
			parent[i] = i;
		}
		int edges = 0;
		int totalCost = 0;
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			if (union(node.a, node.b)) {
				totalCost += node.cost;
				edges++;
			}
		}
		if (edges == color - 2) { // color는 1번부터 시작했으므로 섬의 개수는 color - 1
			System.out.println(totalCost);
		} else {
			System.out.println(-1); // 모든 섬을 연결할 수 없는 경우
		}
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x == y)
			return false;
		parent[x] = y;
		return true;
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static class Node implements Comparable<Node> {
		int a, b, cost;

		Node(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node node) {
			return this.cost - node.cost;
		}
	}

	static void makeBridge(int sx, int sy, int w) {
		int cnt = 0;
		int x = sx, y = sy;
		int nx, ny;
		int id = box[sx][sy];
		while (true) {
			nx = x + way[w][0];
			ny = y + way[w][1];

			if (!inRange(nx, ny))
				break;
			if (box[nx][ny] == id) { // 자기 섬 다시 만남
				break;
			}
			if (box[nx][ny] > 0) {
				if (cnt >= 2) {
					dist[id][box[nx][ny]] = Math.min(dist[id][box[nx][ny]], cnt);
					dist[box[nx][ny]][id] = Math.min(dist[box[nx][ny]][id], cnt);
				}
				break;
			}
			x = nx;
			y = ny;
			cnt += 1;

		}
	}

	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static void bfs(int x, int y, int color) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;
		box[x][y] = color;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int w = 0; w < 4; w++) {
				int nx = now[0] + way[w][0];
				int ny = now[1] + way[w][1];
				if (!inRange(nx, ny) || visited[nx][ny])
					continue;
				if (box[nx][ny] == 1) {
					box[nx][ny] = color;
					visited[nx][ny] = true;
					queue.add(new int[] { nx, ny });

				}
			}
		}
	}

}