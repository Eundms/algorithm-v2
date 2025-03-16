import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; // 전체 용액의 수
	static int[] items;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 순서
		N = Integer.parseInt(br.readLine()); // 전체 용액의 수

		items = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			items[n] = Integer.parseInt(st.nextToken());
		}
		int minDiff = Integer.MAX_VALUE;
		int minLeft = -1, minRight = -1;
		Arrays.sort(items);
		int i = 0, j = N - 1;
		while (i < j) {
			if (Math.abs(items[i] + items[j]) <= minDiff) {
				minDiff = Math.abs(items[i] + items[j]);
				minLeft = items[i];
				minRight = items[j];
			}
			if (items[i] + items[j] < 0) {
				i += 1;
			} else {
				j -= 1;
			}
		}
		System.out.println(minLeft + " " + minRight);
	}

}
