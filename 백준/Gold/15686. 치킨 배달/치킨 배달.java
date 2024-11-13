import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] box;
	static int HOME = 1, CHICKEN = 2;
	static int[] selected;
	static Set<Integer> selectedSet;
	static List<int[]> chickens;
	static int[][] chickPosToId;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chickens = new ArrayList<>();
		box = new int[N][N];
		chickPosToId = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				chickPosToId[i][j] = Integer.MAX_VALUE;
				if (box[i][j] == CHICKEN) {
					chickens.add(new int[] { i, j });
					chickPosToId[i][j] = chickens.size() - 1;
				}
			}
		}

		selected = new int[M]; // 치킨집 개수
		back(0, 0);
		System.out.println(ans);
	}

	static void back(int cnt, int idx) {
		if (cnt == M) {
			selectedSet = new HashSet<>();
			for (int i = 0; i < M; i++) {
				selectedSet.add(selected[i]);
			}
			int val = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (box[i][j] == HOME) {
						int dist = near(i, j);
						val += dist;
					}
				}
			}
			ans = Math.min(ans, val);
			return;
		}
		for (int i = idx; i < chickens.size(); i++) {
			selected[cnt] = i;
			back(cnt + 1, i + 1);
		}
	}

	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int near(int x, int y) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new ArrayDeque<>();
		visited[x][y] = true;
		queue.add(new int[] { x, y, 0 });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (box[now[0]][now[1]] == CHICKEN) {
				if (selectedSet.contains(chickPosToId[now[0]][now[1]])) {
					return now[2];
				}
			}
			for (int w = 0; w < 4; w++) {
				int nx = way[w][0] + now[0];
				int ny = way[w][1] + now[1];
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny])
					continue;
				if (box[nx][ny] == CHICKEN && selectedSet.contains(chickPosToId[nx][ny])) {
					return now[2] + 1;
				}
				visited[nx][ny] = true;
				queue.add(new int[] { nx, ny, now[2] + 1 });

			}
		}
		return 0;
	}

}
