import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, E; // 정점의 개수, 간선의 개수
	static List<Node>[] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine()); // 서로 다른 정점 번호 v1, v2 주어짐
		int v1 = Integer.parseInt(st.nextToken()) - 1;
		int v2 = Integer.parseInt(st.nextToken()) - 1;
		// 1번 정점 -> v1번 -> v2번 -> N번 정점

		// fromStart
		int[] fromStart = new int[N];
		Arrays.fill(fromStart, Integer.MAX_VALUE);
		fromStart[0] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(0, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (fromStart[now.id] < now.cost)
				continue;
			for (Node next : adj[now.id]) {
				int newCost = fromStart[now.id] + next.cost;
				if (newCost < fromStart[next.id]) {
					fromStart[next.id] = newCost;
					pq.add(new Node(next.id, newCost));
				}
			}
		}

		// fromEnd
		int[] fromEnd = new int[N];
		Arrays.fill(fromEnd, Integer.MAX_VALUE);
		fromEnd[N - 1] = 0;
		pq = new PriorityQueue<>();
		pq.add(new Node(N - 1, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (fromEnd[now.id] < now.cost)
				continue;
			for (Node next : adj[now.id]) {
				int newCost = fromEnd[now.id] + next.cost;
				if (newCost < fromEnd[next.id]) {
					fromEnd[next.id] = newCost;
					pq.add(new Node(next.id, newCost));
				}
			}
		}

		// fromV v1 -> v2
		int[] fromV = new int[N];
		Arrays.fill(fromV, Integer.MAX_VALUE);
		fromV[v1] = 0;
		pq = new PriorityQueue<>();
		pq.add(new Node(v1, 0));
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (fromV[now.id] < now.cost)
				continue;
			for (Node next : adj[now.id]) {
				int newCost = fromV[now.id] + next.cost;
				if (newCost < fromV[next.id]) {
					fromV[next.id] = newCost;
					pq.add(new Node(next.id, newCost));
				}
			}
		}
		if (fromV[v2] == Integer.MAX_VALUE) {

		}
		int minCost = Integer.MAX_VALUE;

		if (fromStart[v1] != Integer.MAX_VALUE && fromEnd[v2] != Integer.MAX_VALUE) {
			minCost = Math.min(minCost, fromStart[v1] + fromEnd[v2]);
		}
		if (fromStart[v2] != Integer.MAX_VALUE && fromEnd[v1] != Integer.MAX_VALUE) {
			minCost = Math.min(minCost, fromStart[v2] + fromEnd[v1]);
		}
		if (minCost == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		if (fromV[v2] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		minCost += fromV[v2];
		System.out.println(minCost);
	}

	static class Node implements Comparable<Node> {
		int id, cost;

		Node(int id, int cost) {
			this.id = id;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
