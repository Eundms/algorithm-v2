import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] box = new int[102][102];
	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for (int r = a; r < a + 10; r++) {
				for (int c = b; c < b + 10; c++) {
					box[r][c] = 1;
				}
			}
		}

		int res = 0;
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				if (box[i][j] == 1) {
					for (int d = 0; d < 4; d++) {
						int nx = i + way[d][0];
						int ny = j + way[d][1];
						if (box[nx][ny] == 0) {
							res++;
						}
					}
				}
			}
		}
		System.out.println(res);
	}
}
