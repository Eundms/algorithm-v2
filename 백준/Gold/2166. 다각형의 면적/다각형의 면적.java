import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // 전체 용액의 수
	static long[][] items;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 순서
		N = Integer.parseInt(br.readLine()); // 전체 용액의 수

		items = new long[N + 1][2];
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			items[n][0] = Long.parseLong(st.nextToken());
			items[n][1] = Long.parseLong(st.nextToken());
		}
		items[N][0] = items[0][0];
		items[N][1] = items[0][1];
		long area = 0;
		for (int i = 0; i < N; i++) {
			long x1 = items[i][0];
			long y1 = items[i][1];

			long x2 = items[i + 1][0];
			long y2 = items[i + 1][1];

			area += x1 * y2 - x2 * y1;
		}
		System.out.println(String.format("%.1f", (double) (Math.abs(area) / 2.0)));
	}

}
