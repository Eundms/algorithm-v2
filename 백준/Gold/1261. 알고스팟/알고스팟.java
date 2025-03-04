import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int M, N; // 열, 행
	static int[][] box;
	static int EMPTY = 0, WALL = 1; // 빈 방, 벽
	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				box[i][j] = line.charAt(j) - '0';
			}
		}
		int[][] dist = new int[N][M];
		for (int[] row : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		// (x, y) -> (x+1, y), (x, y+1), (x-1, y), (x, y-1)
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.cost > dist[now.x][now.y]) {
				continue;
			}
			for (int w = 0; w < 4; w++) {
				int nx = now.x + way[w][0];
				int ny = now.y + way[w][1];
				if (!inRange(nx, ny)) {
					continue;
				}
				int newCost = dist[now.x][now.y] + box[nx][ny];
				if (dist[nx][ny] > newCost) {
					dist[nx][ny] = newCost;
					pq.add(new Node(nx, ny, newCost));
				}
			}
		}
		System.out.println(dist[N - 1][M - 1]);
	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

	static class Node implements Comparable<Node> {
		int x, y, cost;

		Node(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

}
