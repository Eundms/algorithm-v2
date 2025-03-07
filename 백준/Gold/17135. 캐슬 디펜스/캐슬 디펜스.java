import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, D;
	static int[][] box;
	static int[] archers = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int maxEnemy = 0;
		// 궁수 배치 (M개의 열 중 3개 선택)
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j < M; j++) {
				for (int k = j + 1; k < M; k++) {
					archers[0] = i;
					archers[1] = j;
					archers[2] = k;
					maxEnemy = Math.max(maxEnemy, simulate());
				}
			}
		}

		System.out.println(maxEnemy);
	}

	static int simulate() {
		int[][] copyBox = new int[N][M];
		for (int i = 0; i < N; i++) {
			copyBox[i] = Arrays.copyOf(box[i], M);
		}
		int count = 0;
		// N번의 턴을 진행 (적들이 아래로 이동)
		for (int n = 0; n < N; n++) {
			List<int[]> targets = new ArrayList<>();
			// 각 궁수가 공격할 적 찾기
			for (int archer : archers) {
				int[] target = findTarget(archer, copyBox);
				if (target != null) {
					targets.add(target);
				}
			}
			// 적 제거
			for (int[] target : targets) {
				if (copyBox[target[0]][target[1]] == 1) {
					copyBox[target[0]][target[1]] = 0;
					count += 1;
				}
			}
			// 적 이동 (마지막 행 제거, 나머지 아래로 이동)
			for (int i = N - 1; i > 0; i--) {
				copyBox[i] = Arrays.copyOf(copyBox[i - 1], M);
			}
			Arrays.fill(copyBox[0], 0);
		}

		return count;
	}

	static int[] findTarget(int archer, int[][] grid) { // 궁수의 위치, 현재 적의 위치를 나타내는 N x M 격자
		int minDist = Integer.MAX_VALUE; // 궁수와 적 사이의 최소 거리
		int targetRow = -1, targetCol = -1;// 공격할 적의 좌표
		for (int r = N - 1; r >= 0; r--) {// 아래쪽부터 탐색 (N-1행부터 0행까지)
			for (int c = 0; c < M; c++) {
				if (grid[r][c] == 1) {// 적이 있는 경우
					int dist = Math.abs(N - r) + Math.abs(archer - c);
					if (dist <= D) {
						if (minDist > dist || (dist == minDist && c < targetCol)) {
							minDist = dist;
							targetRow = r;
							targetCol = c;
						}
					}
				}
			}
		}
		return targetRow == -1 ? null : new int[] { targetRow, targetCol };
	}

}
