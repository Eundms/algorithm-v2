import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] adj;
	static int N; // 트리의 정점 개수 N
	static int u, v; // 친구 관계 트리의 에지

	static boolean[] visited;
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int n = 0; n < N - 1; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}

		visited = new boolean[N + 1]; // 1 - N
		dp = new int[N + 1][2]; // dp[i][0] : 선물 x | dp[i][1] : 선물 O

		dfs(1);

		System.out.println(Math.min(dp[1][0], dp[1][1]));

	}

	static void dfs(int v) {
		visited[v] = true;
		dp[v][0] = 0;
		dp[v][1] = 1;
		for (int u : adj[v]) {
			if (visited[u])
				continue;
			dfs(u);
			dp[v][0] += dp[u][1];
			dp[v][1] += Math.min(dp[u][1], dp[u][0]);
		}

	}

}
