import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] parent = new int[N]; // LIS 경로 추적용
		int[] LISLEN = new int[N]; // 증가하는 부분 수열 길이 저장
		Arrays.fill(LISLEN, 1);

		for (int i = 0; i < N; i++) {
			parent[i] = i; // 자기 자신을 부모로 초기화
		}

		// LIS 계산 (O(N^2))
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (LISLEN[j] + 1 > LISLEN[i]) {
						parent[i] = j; // i의 이전 원소로 j 저장
						LISLEN[i] = LISLEN[j] + 1;
					}
				}
			}
		}

		// 1. LIS 길이 찾기
		int max = 0, sIdx = 0;
		for (int i = 0; i < N; i++) {
			if (LISLEN[i] > max) {
				max = LISLEN[i];
				sIdx = i;
			}
		}

		// 2. LIS 원소 추적
		int[] LIS = new int[max];
		int idx = max - 1;
		while (sIdx != parent[sIdx]) {
			LIS[idx--] = arr[sIdx];
			sIdx = parent[sIdx];
		}
		LIS[idx] = arr[sIdx];

		// 3. 출력
		StringBuilder sb = new StringBuilder();
		for (int num : LIS) {
			sb.append(num).append(" ");
		}

		System.out.println(max);
		System.out.println(sb);
	}
}
