import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] times;
	static List<Integer> adj[];
	static int[] inDegree;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		times = new int[N + 1];
		adj = new ArrayList[N + 1];
		for (int n = 0; n < N + 1; n++) {
			adj[n] = new ArrayList<>();
		}
		inDegree = new int[N + 1];
		dp = new int[N + 1];
		for (int to = 1; to <= N; to++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[to] = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			for (int i = 0; i < cnt; i++) {
				int from = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				inDegree[to] += 1;
			}
		}

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
				dp[i] = times[i];
			}
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : adj[now]) {
				inDegree[next] -= 1;
				dp[next] = Math.max(dp[next], dp[now] + times[next]);
				if (inDegree[next] == 0) {
					queue.add(next);
				}
			}
		}

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

}