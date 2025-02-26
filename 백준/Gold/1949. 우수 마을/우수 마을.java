import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N; // 1 - N까지 번호, Tree구조 방향 X
	static int[] pplCnts;
	// 우수주민 마을 주민수의 총합 최대
	// 인접 x (핑퐁)
	static boolean[] visited;
	static List<Integer> adj[];
	static int[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		pplCnts = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			pplCnts[i] = Integer.parseInt(st.nextToken());
		}

		adj = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}
		dp = new int[N + 1][2];

		// dp[u][0] = dp[v][1] 혹은 dp[v][0]인데 // 적어도 하나의 우수마을과는 인접
		// dp[u][1] = dp[v][0] + pplCnts[u] : 우수마을 선정

		visited = new boolean[N + 1];
		dfs(1);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}

	static void dfs(int u) {
		visited[u] = true;
		dp[u][0] = 0;
		dp[u][1] = pplCnts[u];

		for (int v : adj[u]) {
			if (visited[v])
				continue;
			dfs(v);
			dp[u][1] += dp[v][0];
			dp[u][0] += Math.max(dp[v][0], dp[v][1]);
		}

	}

}
