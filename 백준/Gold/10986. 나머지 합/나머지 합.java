import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] count = new int[M]; // 나머지별 개수
		long sum = 0;
		long result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum += num; // 누적합을 계속 더해하고
			int mod = (int) (sum % M); // 누적합을 M으로 나눈 나머지를 구함
			if (mod == 0)
				result++; // 0 ~ i 구간 합이 M으로 나누어떨어지는 경우
			count[mod]++; // 나머지 누적
		}

		// 나머지 같은 것들 중 2개를 고르는 조합의 수 계산
		for (int i = 0; i < M; i++) {
			if (count[i] >= 2) {
				result += (long) count[i] * (count[i] - 1) / 2; // i를 고르는 수 조하
			}
		}
		System.out.println(result);
	}
}
