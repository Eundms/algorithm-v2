import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, C; // 집의 개수, 공유기의 개수
	static int[] arr;
	static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr); // 1 2 4 8 9
		d = new int[N];
		for (int i = 1; i < N; i++) {
			d[i] = arr[i] - arr[i - 1];
		}
		// 공유기 C개 설치 & 인접한 두 공유기 사이 거리 최대

		// 공유기 거리 1, 2, 3... 최대 중 하나 선택
		int maxDist = 0;
		int left = 1, right = arr[N - 1] - arr[0];
		while (left <= right) {
			int dist = (left + right) / 2;
			if (isPossible(dist)) {
				maxDist = Math.max(maxDist, dist);
				left = dist + 1;
			} else {
				right = dist - 1;
			}
		}
		System.out.println(maxDist);
	}

	// 인접한 거리가 dist 거리이상이 되게 c개의 공유기설치 가능?
	static boolean isPossible(int dist) {

		int cnt = 1; // 하나는 설치 가능
		int prev = arr[0];
		for (int i = 1; i < N; i++) {
			if (arr[i] - prev >= dist) { // 인접한 거리가 dist거리 이상
				cnt += 1;
				prev = arr[i];
			}
		}
		return cnt >= C;
	}

}
