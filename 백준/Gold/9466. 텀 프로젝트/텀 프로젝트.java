import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] student;
	static int[] visited;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine()); // 학생 수
			student = new int[n + 1]; 
			visited = new int[n + 1]; // 방문 상태 (0: 미방문, 1: 방문 중, 2: 방문 완료)
			count = 0; 

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				student[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				if (visited[i] == 0) { // 방문하지 않은 학생만 탐색
					dfs(i);
				}
			}

			sb.append((n - count) + "\n"); // 팀을 이루지 못한 학생 수 출력
		}
		System.out.print(sb);
	}

	private static void dfs(int node) {
		visited[node] = 1; // 방문 중 표시
		int next = student[node]; // 다음 노드

		if (visited[next] == 0) {
			dfs(next); // 아직 방문하지 않았다면 계속 탐색
		} else if (visited[next] == 1) {
			// 방문 중(사이클 발견)
			int cur = next;
			while (cur != node) {
				count++; // 사이클 내 학생 수 증가
				cur = student[cur];
			}
			count++; // 마지막 노드도 포함
		}

		visited[node] = 2; // 방문 완료
	}
}
