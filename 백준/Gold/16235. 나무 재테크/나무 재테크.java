import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static int[][] A; // 겨울에 s2d22가 추가할 양분

	static int[][] food; // 현재 양분
	static List<Tree> trees; // 여러 나무 한 칸 가능

	static int[][] way = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // N x N 크기의 땅
		M = Integer.parseInt(st.nextToken()); // 나무의 개수
		K = Integer.parseInt(st.nextToken()); // K년 지난후 살아 있는 나무의 개수

		trees = new ArrayList<>();
		food = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				food[i][j] = 5; // 가장 처음에 모든 칸에 5만큼 들어있음
			}
		}

		// 양분 배열의 값
		A = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// M개의 줄, 상도가 심은 나무의 정보 x,y,z
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1; // 위치
			int age = Integer.parseInt(st.nextToken()); // 나이
			trees.add(new Tree(x, y, age));
		}

		// 봄 > (food-나이)? +1 : 0
		// 여름 > 위치 양분 += 죽은나무나이/2
		// 가을 > 나이 % 5 == 0 -> 8개 칸에 나이 1 나무 생김
		// 겨울 > 땅에 양분 추가 A[r][c]
		// 번식하는 나무의 나이 : 5의 배수
		// 인접한 8개의 칸에 나이가 1인 나무 생김
		while (K-- > 0) {
			// 봄
			Collections.sort(trees);
			for (int t = 0; t < trees.size(); t++) {
				int i = trees.get(t).x, j = trees.get(t).y;
				if (food[i][j] - trees.get(t).age >= 0) {
					food[i][j] -= trees.get(t).age;
					trees.get(t).age += 1;
				} else {
					trees.get(t).isAlive = false;
				}
			}

			// 여름
			List<Tree> next = new ArrayList<>(); // 필터링 처리한
			for (int t = 0; t < trees.size(); t++) {
				if (trees.get(t).isAlive == false) {
					// 봄에 죽은 나무가 양분으로 변함
					int i = trees.get(t).x;
					int j = trees.get(t).y;
					food[i][j] += trees.get(t).age / 2;
				} else {
					next.add(trees.get(t));
				}
			}
			trees = next;

			// 가을
			next = copyList(trees);
			for (int t = 0; t < trees.size(); t++) {
				if (trees.get(t).age % 5 == 0) {
					int i = trees.get(t).x, j = trees.get(t).y;
					// 나이가 1인 나무가 생김
					for (int w = 0; w < 8; w++) {
						int nx = way[w][0] + i;
						int ny = way[w][1] + j;
						if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
							next.add(new Tree(nx, ny, 1));
						}
					}
				}
			}

			trees = next;
			// 겨울 양분 추가
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					food[i][j] += A[i][j];
				}
			}

		}

		int aliveCnt = trees.size();

		System.out.println(aliveCnt);

	}

	static List<Tree> copyList(List<Tree> tree) {
		List<Tree> ans = new ArrayList<>();
		for (Tree t : tree) {
			ans.add(t);
		}
		return ans;
	}

	static class Tree implements Comparable<Tree> {
		int x, y, age;
		boolean isAlive;

		Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
			this.isAlive = true;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}

}
