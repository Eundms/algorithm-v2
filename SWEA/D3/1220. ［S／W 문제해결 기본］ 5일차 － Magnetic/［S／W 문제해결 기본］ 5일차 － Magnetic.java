import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T;
	static int N;
	static int[][] box;
	static int TO_BOTTOM = 1, TO_TOP = 2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = 10;
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			box = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					box[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 열마다 확인해서 TO_BOTTOM -> TO_TOP으로 변화값이 있는지
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				boolean isDeadLock = false;
				for (int i = 0; i < N; i++) {
					if (box[i][j] == TO_BOTTOM) {
						isDeadLock = true;
					}
					if (isDeadLock && box[i][j] == TO_TOP) {
						cnt += 1;
						isDeadLock = false;
					}

				}
			}
			System.out.println("#" + test + " " + cnt);
		}
	}

}