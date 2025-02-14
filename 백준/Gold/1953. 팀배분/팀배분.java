import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int V; // 학생들의 수 1- N
	static List<Integer>[] adj;
	static int[] color;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		adj = new ArrayList[V + 1];
		for (int i = 0; i < V + 1; i++) {
			adj[i] = new ArrayList<>();
		}
		color = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int c = 0; c < cnt; c++) {
				int hate = Integer.parseInt(st.nextToken());
				adj[i].add(hate);
				adj[hate].add(i);
			}
		}

		for (int v = 1; v <= V; v++) {
			if (color[v] == 0) {
				dfs(v, 1); // 팀 나누는 것이 불가능한 경우 없음
			}
		}
		List<Integer> blue = new ArrayList<>();
		List<Integer> white = new ArrayList<>();
		for (int i = 1; i <= V; i++) {
			if (color[i] == -1) {
				blue.add(i);
			} else {
				white.add(i);
			}
		}
		Collections.sort(blue);
		Collections.sort(white);
		System.out.println(blue.size());
		for (int v : blue) {
			System.out.print(v + " ");
		}
		System.out.println();
		System.out.println(white.size());
		for (int v : white) {
			System.out.print(v + " ");
		}
		System.out.println();
	}

	static boolean dfs(int v, int c) {
		color[v] = c;
		for (int next : adj[v]) {
			if (color[next] == 0) {
				if (!dfs(next, -c)) {
					return false;
				}
			} else if (color[next] == c) {
				return false;
			}
		}
		return true;
	}
}