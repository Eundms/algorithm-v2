import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] box;
	static int[] team;
	static boolean[] isVisited;
	static int ans = Integer.MAX_VALUE;

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
		for (int x = 1; x <= N / 2 + 1; x++) {
			team = new int[x];
			isVisited = new boolean[N];
			back(0, 0);
		}

		System.out.println(ans);
	}

	static void back(int cnt, int k) {
		if (cnt == team.length) {
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < team.length; i++) {
				set.add(team[i]);
			}

			int sum = 0, sumelse = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (set.contains(i) && set.contains(j)) {
						sum += box[i][j];
					} else if (!set.contains(i) && !set.contains(j)) {
						sumelse += box[i][j];
					}
				}
			}

			ans = Math.min(Math.abs(sumelse - sum), ans);
			return;
		}

		for (int i = k; i < N; i++) {
			if (isVisited[i]) {
				continue;
			}
			team[cnt] = i;
			isVisited[i] = true;
			back(cnt + 1, i + 1);
			isVisited[i] = false;
		}
	}

}