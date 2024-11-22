import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, K; // 집을 방문하는 친구의 수, 성냥의 개수
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int ans = 0; // 난로 켜져 있는 시간의 최솟값
		// 해당 시각에 난로 켜기 -> 난로 계속 껐다 켜는게 최소값 -> 한계(K)가 정해져있음
		// (텀 짧은 것부터 N-k) + 그외 K개 x 1
		int[] near = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			near[i] = arr[i + 1] - arr[i];
		}
		Arrays.sort(near);
		for (int i = 0; i < N - K; i++) {
			ans += near[i];
		}
		ans += K;
		System.out.println(ans);
	}

}
