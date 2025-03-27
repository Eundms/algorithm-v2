import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R; // 헛간의 개수 소들의 길(양방향)
	static List<Node> adj[];
	static int[] values;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); // 수색 가능 범위
		R = Integer.parseInt(st.nextToken()); // 길의 개수

		adj = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		// n개의 숫자가 차례대로 각 구역에 있는 아이템수 t를 알려줌
		values = new int[N + 1]; // 1 - N
		st = new StringTokenizer(br.readLine());
		for (int v = 1; v <= N; v++) {
			values[v] = Integer.parseInt(st.nextToken());
		}
		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken()); // 거리
			adj[a].add(new Node(b, l));
			adj[b].add(new Node(a, l));
		}

		int maxItem = 0;
		int[] dist = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(dist, Integer.MAX_VALUE);

			PriorityQueue<Node> pq = new PriorityQueue<>();
			dist[i] = 0;
			pq.add(new Node(i, 0));
			while (!pq.isEmpty()) {
				Node now = pq.poll();

				for (Node next : adj[now.to]) {
					if (dist[next.to] > dist[now.to] + next.cost) {
						dist[next.to] = dist[now.to] + next.cost;
						pq.add(new Node(next.to, dist[next.to]));
					}
				}
			}
			int answer = 0;
			for (int n = 1; n <= N; n++) {

				if (dist[n] <= M) {
					answer += values[n];
				}
			}
			maxItem = Math.max(maxItem, answer);
		}
		System.out.println(maxItem);

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
