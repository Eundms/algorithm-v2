// [BOJ] 0 만들기 https://www.acmicpc.net/problem/7490
// 이전 처리중인 숫자 : 공백 고르면 누적, + 나 - 고르면 해당 값이 더해지고 빠진 것

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int S, D; // 시작점, 도착점
	static Map<Integer, List<Edge>> adj;
	static Set<List<Integer>> isUsed;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if (N == 0 && M == 0)
				break;
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());

			adj = new HashMap<>();
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int U = Integer.parseInt(st.nextToken());
				int V = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				// U -> V : P 단방향
				adj.computeIfAbsent(U, k -> new ArrayList<>()).add(new Edge(V, P));
			}

			isUsed = new HashSet<>();

			int[] dist = findDists(); // S -> D 최단 경로 일 때 dist[] 구하기

			removeShortestPaths(dist);// bfs역추적 + 모든 최단 경로 제거

			int[] nextMinDist = findDists(); // find 다음 최단 경로
			System.out.println(nextMinDist[D] == Integer.MAX_VALUE ? -1 : nextMinDist[D]);

		}

	}

	// bfs 역추적 + 모든 최단 경로 제거
	static void removeShortestPaths(int[] dist) {
		// dist[i] = S에서 i까지 가는 최소 비용
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(D);
		boolean[][] visited = new boolean[N][N];
		while (!queue.isEmpty()) {
			int to = queue.poll();

			for (Map.Entry<Integer, List<Edge>> entry : adj.entrySet()) {
				int from = entry.getKey();
				for (Edge e : entry.getValue()) {
					if (e.to == to && dist[to] == dist[from] + e.cost) {
						if (visited[from][to])
							continue;
						visited[from][to] = true;
						isUsed.add(List.of(from, to));
						queue.add(from); // 역방향으로 탐색
					}
				}
			}
		}
	}

	static int[] findDists() {
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(S, 0));
		dist[S] = 0;

		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if (dist[now.to] < now.cost)
				continue;
			for (Edge next : adj.getOrDefault(now.to, new ArrayList<>())) {
				if (isUsed.contains(List.of(now.to, next.to)))
					continue;
				if (dist[next.to] > dist[now.to] + next.cost) {
					dist[next.to] = dist[now.to] + next.cost;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}
		return dist;

	}

	static class Edge implements Comparable<Edge> {
		int to, cost;

		Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e) {
			return this.cost - e.cost;
		}
	}

}
