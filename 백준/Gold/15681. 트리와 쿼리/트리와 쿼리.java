import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, R, Q; // 정점의 수, 루트의 번호, 쿼리의 수

	static List<Integer>[] adj;
	static int u, v;

	static boolean[] visited;
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int n = 0; n < N - 1; n++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			adj[u].add(v);
			adj[v].add(u);
		}

		visited = new boolean[N + 1]; // 1 - N
		dp = new int[N + 1];

		dfs(R);

		for (int q = 0; q < Q; q++) {
			int v = Integer.parseInt(br.readLine());
			System.out.println(dp[v]);
		}

	}

	static void dfs(int v) {
		visited[v] = true;
		for (int u : adj[v]) {
			if (visited[u])
				continue;
			dfs(u);
		}

		dp[v] = 1;
		for (int u : adj[v]) {
			dp[v] += dp[u];
		}

	}

}
