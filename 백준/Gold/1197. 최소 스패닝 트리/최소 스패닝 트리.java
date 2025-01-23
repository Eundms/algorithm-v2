import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V, E; // 정점의 개수, 간선의 개수
	static List<Node>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adj = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
		}

		System.out.println(prim());
	}

	static int prim() {
		int[] dist = new int[V + 1]; // 각 정점까지의 최소 비용
		boolean[] visited = new boolean[V + 1]; // 방문 여부
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(1, 0)); // 시작 정점 (1번 정점)
		dist[1] = 0;

		int cost = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			// 이미 MST에 포함된 정점은 스킵
			if (visited[now.to])
				continue;

			visited[now.to] = true; // 현재 정점 방문
			cost += now.cost;

			// 인접한 정점들 갱신
			for (Node next : adj[now.to]) {
				if (!visited[next.to] && dist[next.to] > next.cost) {
					dist[next.to] = next.cost;
					pq.add(new Node(next.to, next.cost));
				}
			}
		}

		return cost; // MST의 총 비용 반환
	}

	static class Node implements Comparable<Node> {
		int to, cost;

		Node(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
