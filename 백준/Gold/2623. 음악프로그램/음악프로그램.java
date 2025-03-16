import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 가수의 수, 보조 PD의 수
	static int[] indegree;
	static List<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 순서
		N = Integer.parseInt(st.nextToken()); // 가수의 수
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		indegree = new int[N + 1];
		M = Integer.parseInt(st.nextToken()); // 보조 PD의 수
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int[] person = new int[cnt];
			for (int c = 0; c < cnt; c++) {
				person[c] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i < cnt; i++) {
				indegree[person[i]]++;
				adj[person[i - 1]].add(person[i]);
			}
		}
		visited = new boolean[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
				visited[i] = true;
			}
		}
		// System.out.println(Arrays.toString(indegree));
		StringBuilder sb = new StringBuilder();
		while (!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append("\n");
			for (int next : adj[now]) {
				if (indegree[next] > 0) {
					indegree[next] -= 1;
				}
				if (indegree[next] == 0 && !visited[next]) {
					visited[next] = true;
					queue.add(next);
				}
			}
		}
		if (sb.length() == 0 || !isAllVisit()) {
			System.out.println(0);
			return;
		}

		System.out.println(sb);

	}

	static boolean isAllVisit() {
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}
}
