import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] group;
	static int[] indi;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		group = new int[M];
		indi = new int[M];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int packPrice = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			group[m] = packPrice;
			indi[m] = price;
		}

		Arrays.sort(group);
		Arrays.sort(indi);

		int min = Integer.MAX_VALUE;
		if (group[0] >= indi[0] * 6) { // 낱개로 다 사기
			min = indi[0] * N;
		} else {
			min = group[0] * (N / 6);
			min += Math.min(group[0], indi[0] * (N % 6));
		}

		System.out.println(min);
	}

}