import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<Node>[] adj;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, cost)); // 단방향 그래프
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int[] dist = new int[N + 1];
		int[] preCity = new int[N + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(preCity, -1);

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (dist[now.x] < now.cost)
				continue;
			for (Node next : adj[now.x]) {
				int nextCost = next.cost + dist[now.x];
				if (nextCost < dist[next.x]) {
					dist[next.x] = nextCost;
					preCity[next.x] = now.x;
					pq.add(new Node(next.x, nextCost));
				}
			}
		}

		System.out.println(dist[end]);

		// 경로 찾기
		Stack<Integer> stack = new Stack<>();
		int cnt = 0;
		while (end != -1) {
			stack.push(end);
			end = preCity[end];
			cnt++;
		}

		System.out.println(cnt);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	static class Node implements Comparable<Node> {
		int x, cost;

		Node(int x, int cost) {
			this.x = x;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}
