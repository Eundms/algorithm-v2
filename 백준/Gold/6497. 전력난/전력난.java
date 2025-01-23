import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V, E; // 정점의 개수(집의 수), 간선의 개수(길의 수)
	// 집 번호 : 0 ~ V-1
	static PriorityQueue<Node> pq;
	static int[] parent;

	static class Node implements Comparable<Node> {
		int a, b, cost;

		Node(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			if (V == 0 && E == 0) {
				break;
			}

			parent = new int[V];
			for (int v = 0; v < V; v++) {
				parent[v] = v;
			}

			int sum = 0;
			pq = new PriorityQueue<>();
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				// x번 집과 y번 집 사이에 양방향 도로, 거리가 z미터
				sum += z;
				pq.add(new Node(x, y, z));
			}
			int cost = 0;
			while (!pq.isEmpty()) {
				Node now = pq.poll();
				int parentA = find(now.a);
				int parentB = find(now.b);
				if (parentA != parentB) {
					cost += now.cost;
					union(now.a, now.b);
				}
			}
			System.out.println(sum - cost);

		}
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y)
			parent[x] = y;
		else
			parent[y] = x;

	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

}