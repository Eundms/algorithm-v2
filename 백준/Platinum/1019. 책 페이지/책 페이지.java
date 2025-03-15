import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();

		int[] count = new int[10]; // 0~9 숫자 등장 횟수 저장
		int factor = 1; // 현재 자리수 (1의 자리 → 10의 자리 → 100의 자리...)

		while (factor <= n) {
			int lower = n - (n / factor) * factor; // 현재 자리보다 낮은 숫자들
			int current = (n / factor) % 10; // 현재 자리 숫자
			int higher = n / (factor * 10); // 현재 자리보다 높은 숫자들

			// 0~9 숫자의 등장 횟수를 자리수별로 계산
			for (int d = 0; d <= 9; d++) {
				if (d < current) {
					count[d] += (higher + 1) * factor;
				} else if (d == current) {
					count[d] += higher * factor + (lower + 1);
				} else {
					count[d] += higher * factor;
				}
			}
			count[0] -= factor;

			factor *= 10; // 자리수를 증가 (1 → 10 → 100 → ...)
		}

		// 결과 출력
		for (int i = 0; i < 10; i++) {
			System.out.print(count[i] + " ");
		}
	}
}
