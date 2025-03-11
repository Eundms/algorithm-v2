import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N; 
	static int[] fibo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		fibo = new int[N + 1];
		fibo[1] = fibo[2] = 1;
		for (int i = 3; i <= N; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		fib(N);
		System.out.println(cnt + " " + (N - 2));
	}

	static int cnt = 0;

	static int fib(int n) {
		if (n == 1 || n == 2) {
			cnt += 1;
			return 1;
		}

		return fib(n - 1) + fib(n - 2);
	}

}