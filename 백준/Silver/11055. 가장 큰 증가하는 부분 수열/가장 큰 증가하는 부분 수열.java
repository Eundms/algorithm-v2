import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N; // 수열의 크기
	static int[] arr;
	static int[] sumOfAsc;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		sumOfAsc = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			sumOfAsc[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					sumOfAsc[i] = Math.max(sumOfAsc[j] + arr[i], sumOfAsc[i]);
				}
			}
			max = Math.max(max, sumOfAsc[i]);
		}

		System.out.println(max);
	}

}
