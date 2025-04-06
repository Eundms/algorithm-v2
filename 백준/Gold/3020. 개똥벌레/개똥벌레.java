import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 장애물의 크기
		int H = Integer.parseInt(st.nextToken()); //

		int[] bottom = new int[H + 2];
		int[] top = new int[H + 2];

		for (int i = 0; i < N; i++) {
			int len = Integer.parseInt(br.readLine());
			if (i % 2 == 0) {
				bottom[len]++;
			} else {
				top[len]++;
			}
		}

		// 누적합 계산
		for (int i = H; i >= 1; i--) {
			bottom[i] += bottom[i + 1];
			top[i] += top[i + 1];
		}
		int min = N;
		int count = 0;

		for (int h = 1; h <= H; h++) {
			int obstacle = bottom[h] + top[H - h + 1];
			if (obstacle < min) {
				min = obstacle;
				count = 1;
			} else if (obstacle == min) {
				count++;
			}
		}

		System.out.println(min + " " + count);

	}
}
