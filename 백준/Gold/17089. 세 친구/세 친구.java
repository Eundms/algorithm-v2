import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 세친구
	static int N, M; // 사람의 수, 친구 관계의 수
	static boolean[][] adjMatrix;
	static int[] cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 사람의 수
		M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
		cnt = new int[N + 1];
		adjMatrix = new boolean[N + 1][N + 1];
		for (int m = 0; m < M; m++) { // 둘째줄 ~ M개의 줄
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adjMatrix[A][B] = true;
			adjMatrix[B][A] = true;
			cnt[A]++;
			cnt[B]++;
		}
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (!adjMatrix[i][j])
					continue;
				for (int k = j + 1; k <= N; k++) {
					if (adjMatrix[i][k] && adjMatrix[k][j]) {
						res = Math.min(res, cnt[i] + cnt[j] + cnt[k] - 6);
					}
				}
			}
		}

		System.out.println(res == Integer.MAX_VALUE ? "-1" : String.valueOf(res));

	}
}
