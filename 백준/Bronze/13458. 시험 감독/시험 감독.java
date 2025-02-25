import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // N개의 시험장
	static int[] A; // 응시자수
	static int B, C; // 총 감독관이 감시할 수 있는 응시자수, 부 감독과나이 감시할 수 있는 응시자수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken()); // 감시할 수 있는 응시자의 수
		C = Integer.parseInt(st.nextToken());
		long ans = N;
		for (int a : A) {
			if (a - B > 0) {
				ans += (a - B + C - 1) / C;

			}
		}
		System.out.println(ans);
	}

}
