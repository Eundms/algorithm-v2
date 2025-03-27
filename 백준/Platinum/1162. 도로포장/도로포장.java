import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static List<Node>[] adj;
	static long[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시 수
		M = Integer.parseInt(st.nextToken()); // 도로 수
		K = Integer.parseInt(st.nextToken()); // 포장 가능 횟수

		adj = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()); // 거리
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
		}

		dist = new long[N + 1][K + 1];
		for (int n = 0; n < N + 1; n++) {
			Arrays.fill(dist[n], Long.MAX_VALUE); // Long 최대값으로 초기화
		}
		PriorityQueue<State> pq = new PriorityQueue<>();
		pq.add(new State(1, 0, 0));
		dist[1][0] = 0;
		while (!pq.isEmpty()) {
			State now = pq.poll();
			if (now.dist > dist[now.nodeId][now.usedK]) // 가능성 없는 경우 사전에 가지치기
				continue;

			for (Node next : adj[now.nodeId]) {
				// 도로 포장 안함
				if (dist[next.to][now.usedK] > now.dist + next.dist) {
					dist[next.to][now.usedK] = now.dist + next.dist;
					pq.add(new State(next.to, now.usedK, dist[next.to][now.usedK])); // 지금까지의 거리 + 다음까지의 거리
				}

				// 도로 포장 함
				if (now.usedK < K && dist[next.to][now.usedK + 1] > now.dist) {// 현재 -> 다음 (다음상태 : usedK + 1)
					dist[next.to][now.usedK + 1] = now.dist;
					pq.add(new State(next.to, now.usedK + 1, dist[next.to][now.usedK + 1]));
				}
			}
		}
		long minCost = Long.MAX_VALUE;
		int minK = 0;
		for (int i = 0; i <= K; i++) {
			if (dist[N][i] < minCost) {
				minCost = dist[N][i];
				minK = i;
			}
		}
		System.out.println(minCost);
	}

	static class State implements Comparable<State> {
		int nodeId, usedK;
		long dist;

		State(int nodeId, int usedK, long dist) {
			this.nodeId = nodeId;
			this.usedK = usedK;
			this.dist = dist;
		}

		@Override
		public int compareTo(State o) {
			return Long.compare(this.dist, o.dist); // Long 정렬 방식
		}
	}

	static class Node {
		int to, dist;

		Node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}

}
