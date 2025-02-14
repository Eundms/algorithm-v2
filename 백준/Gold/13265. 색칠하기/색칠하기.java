import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int V, E;
	static List<Integer>[] adj;
	static int[] color;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());// 1- v번 정점
			E = Integer.parseInt(st.nextToken());
			adj = new ArrayList[V + 1];
			for (int v = 0; v < V + 1; v++) {
				adj[v] = new ArrayList<>();
			}
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()); // 인접한 두 정점의 번호 u, v
				int v = Integer.parseInt(st.nextToken());
				adj[u].add(v);
				adj[v].add(u);
			}
			color = new int[V + 1];
			String ans = "possible";
			for (int v = 1; v <= V; v++) {
				if (color[v] == 0) {
					if (!dfs(v, 1)) {
						ans = "im" + ans;
                        break;
					}
				}
			}
			System.out.println(ans);
		}

	}

	static boolean dfs(int v, int c) {
		color[v] = c;
		for (int next : adj[v]) {
			if (color[next] == 0) { // 방문 x ->
				if (!dfs(next, -c)) // 반대 색으로 방문
					return false;
			} else if (color[next] == c) { // 방문한적이 있는데 색이 현재 색이랑 같다 == 인접한 색이 같음
				return false;
			}
		}
		return true;
	}

}