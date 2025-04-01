import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int[] water;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		water = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			water[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(water);
		int cnt = 1;
		int last = water[0] + L;
		for (int i = 1; i < N; i++) {
			if (last <= water[i]) {
				last = water[i] + L;
				cnt += 1;
			}
		}
		System.out.println(cnt);
	}

}