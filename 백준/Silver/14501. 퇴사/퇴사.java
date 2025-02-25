import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // 내림차순 순서, 어떤 순서로 서 있는지
	static int[] times;
	static int[] prices;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		times = new int[N];
		prices = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			times[i] = Integer.parseInt(st.nextToken());
			prices[i] = Integer.parseInt(st.nextToken());
		}
		back(0, 0);
		System.out.println(max);
	}

	static int max = 0;

	static void back(int t, int p) {
		if (t >= N) {
			max = Math.max(max, p);
			return;
		}
		if (t + times[t] <= N) {
			back(t + times[t], p + prices[t]);
		}
		back(t + 1, p);

	}

}
