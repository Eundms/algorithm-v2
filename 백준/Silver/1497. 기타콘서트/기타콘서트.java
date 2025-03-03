import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 기타의 개수, 곡의 개수
	static int minGuitar = Integer.MAX_VALUE;
	static int maxSong = Integer.MIN_VALUE;
	static boolean[][] covered;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 기타의 개수
		M = Integer.parseInt(st.nextToken()); // 곡의 개수

		covered = new boolean[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String guitar = st.nextToken();
			String str = st.nextToken();
			for (int i = 0; i < M; i++) {
				covered[n][i] = str.charAt(i) == 'Y';
			}
		}

		back(0, 0, new boolean[M]);
		if (minGuitar == 0) {
			System.out.println(-1);
		} else {
			System.out.println(minGuitar);

		}
	}

	static void back(int id, int guitarCnt, boolean[] isSongCovered) {
		if (id == N) {
			int songCnt = 0;
			for (boolean b : isSongCovered) {
				songCnt += b ? 1 : 0;
			}
			if (maxSong <= songCnt) {
				maxSong = songCnt;
				minGuitar = Math.min(guitarCnt, minGuitar);
			}
			return;
		}
		boolean[] nextIsSongCovered = new boolean[M];
		// 현재 기타 선택
		for (int i = 0; i < M; i++) {
			nextIsSongCovered[i] = covered[id][i] || isSongCovered[i];
		}
		back(id + 1, guitarCnt + 1, nextIsSongCovered);

		// 현재 기타 선택 x
		back(id + 1, guitarCnt, isSongCovered);
	}

}
