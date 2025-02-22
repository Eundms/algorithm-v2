import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T; // 테스트케이스의 개수
	static int N, K; // 건물의 개수, 건물 간의 건설 순서 규칙의 총 개수
	static List<Integer> adj[];
	static int[] indegree;
	static int[] time;
	static int W;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine()); // 테스트케이스의 수
		StringTokenizer st;
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 건물의 개수
			K = Integer.parseInt(st.nextToken()); // 건물 순서 규칙의 총 개수

			time = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}

			adj = new ArrayList[N + 1];
			for (int i = 0; i < N + 1; i++) {
				adj[i] = new ArrayList<>();
			}

			indegree = new int[N + 1];
			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				adj[x].add(y);
				indegree[y] += 1;
			}
			int[] result = new int[N + 1];
			visited = new boolean[N + 1];
			W = Integer.parseInt(br.readLine()); // 승리하기 위해 건설해야 할 건물의 번호
			Queue<Integer> queue = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				if (indegree[i] == 0) {
					visited[i] = true;
					queue.add(i);
					result[i] = time[i];
				}
			}

			while (!queue.isEmpty()) {
				int now = queue.poll(); // 가장 앞에 있는 값을 뽑기

				for (int next : adj[now]) {
					if (visited[next]) {
						continue;
					}
					result[next] = Math.max(result[next], result[now] + time[next]); // 선행 건물이 처리될 때마다

					indegree[next] -= 1;
					if (indegree[next] == 0) {
						visited[next] = true;
						queue.add(next);
					}
				}
			}

			// 건설 완료하는 데 드는 최소 시간
			System.out.println(result[W]);
		}
	}

}
