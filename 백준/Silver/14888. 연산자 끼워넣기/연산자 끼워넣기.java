import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] A;
	static int[] operator;
	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		operator = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}

		back(operator, A[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

	static void back(int[] operator, int result, int cnt) {
		if (cnt == N) {
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}
		if (operator[0] > 0) {
			operator[0] -= 1;
			back(operator, result + A[cnt], cnt + 1);
			operator[0] += 1;
		}
		if (operator[1] > 0) {
			operator[1] -= 1;
			back(operator, result - A[cnt], cnt + 1);
			operator[1] += 1;
		}
		if (operator[2] > 0) {
			operator[2] -= 1;
			back(operator, result * A[cnt], cnt + 1);
			operator[2] += 1;
		}
		if (operator[3] > 0) {
			operator[3] -= 1;
			back(operator, result / A[cnt], cnt + 1);
			operator[3] += 1;
		}

	}

}
