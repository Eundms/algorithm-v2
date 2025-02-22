import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N; // 건물의 종류 수
	static List<Integer>[] adj;
	static int[] indegree;
	static int[] time;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		adj = new ArrayList[N + 1];
		for (int n = 0; n < N + 1; n++) {
			adj[n] = new ArrayList<>();
		}

		time = new int[N + 1];
		indegree = new int[N + 1];
		for (int id = 1; id <= N; id++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			time[id] = t;

			while (true) {
				int prev = Integer.parseInt(st.nextToken());
				if (prev == -1)
					break;
				adj[prev].add(id); // A -> B
				indegree[id]++;
			}
		}

		int[] dp = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
				visited[i] = true;
				dp[i] = time[i];
			}
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : adj[now]) {
				if (visited[next]) {
					continue;
				}
				dp[next] = Math.max(dp[now] + time[next], dp[next]);
				indegree[next] -= 1;
				if (indegree[next] == 0) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			System.out.println(dp[i] + " ");
		}

	}

}
