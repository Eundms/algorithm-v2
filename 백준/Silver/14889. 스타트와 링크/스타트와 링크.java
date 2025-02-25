import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // 내림차순 순서, 어떤 순서로 서 있는지
	static int[][] box;
	static boolean[] visited;
	static int minDiff = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		box = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		visited = new boolean[N];
		perm(0, 0);
		System.out.println(minDiff);
	}

	static void perm(int cnt, int start) {
		if (cnt == N / 2) {

			int teamA = 0, teamB = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i] && visited[j]) {
						teamA += box[i][j];
					}
					if (!visited[i] && !visited[j]) {
						teamB += box[i][j];

					}
				}
			}

			minDiff = Math.min(Math.abs(teamA - teamB), minDiff);
			return;
		}

		for (int i = start; i < N; i++) {

			visited[i] = true;
			perm(cnt + 1, i + 1);
			visited[i] = false;
		}
	}

}
