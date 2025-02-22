import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 문제의 수, 먼저 푸는 것이 좋은 문제에 대한 정보의 개수
	static List<Integer>[] adj;
	static int[] indegree;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 문제의 수
		M = Integer.parseInt(st.nextToken()); // 먼저 푸는 것이 좋은 문제에 대한 정보의 개수

		adj = new ArrayList[N + 1];
		for (int n = 0; n < N + 1; n++) {
			adj[n] = new ArrayList<>();
		}
		indegree = new int[N + 1];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj[A].add(B); // A -> B
			indegree[B]++;
		}

		boolean[] visited = new boolean[N + 1];
		// 쉬운 문제 먼저 -> 진입 차수가 0인 노드 중에서 번호가 작은 문제부터 풀기
		// 따라서, PriorityQueue 사용
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
				visited[i] = true;
			}
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for (int next : adj[now]) {
				if (visited[next]) {
					continue;
				}
				indegree[next] -= 1;
				if (indegree[next] == 0) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}

	}

}
