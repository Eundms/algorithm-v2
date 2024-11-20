import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 컴퓨터의 수, 연결할 수 있는 선의 수
	static PriorityQueue<Node> pq;
	static int[] parent;

	// N 개중 K개 알파벳 선택
	// 주어진 문자열을 읽을 수 있는지 여부 확인 => 문자열을 미리 사용된 알파벳
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 컴퓨터의 수
		M = Integer.parseInt(br.readLine()); // 연결할 수 있는 선의 수

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		pq = new PriorityQueue<>();
		// a->b 비용 c
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			// a -> b 연결하는데 비용 c만큼 들음
			pq.add(new Node(a, b, c));
		}

		int cnt = 0, total = 0;
		while (cnt < N - 1 && !pq.isEmpty()) { // 모든 컴퓨터 연결, 비용 작은 거부터 뽑아서 연결
			Node node = pq.poll();
			if (find(node.from) != find(node.to)) {
				cnt += 1;
				union(node.from, node.to);
				total += node.value;
			}
		}
		System.out.println(total);
	}

	static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		if (find(x) == find(y))
			return;
		x = find(x);
		y = find(y);
		parent[x] = y;
	}

	static class Node implements Comparable<Node> {
		int from, to, value;

		Node(int from, int to, int value) {
			this.from = from;
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) { // 작은 순서
			return this.value - o.value;
		}
	}

}
