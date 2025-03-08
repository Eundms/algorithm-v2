import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		System.out.println(lisLength(arr));
	}

	public static int lisLength(int[] arr) {
		List<Integer> lis = new ArrayList<>();

		for (int x : arr) {
			int pos = Collections.binarySearch(lis, x); // 값이 없다면, -(들어갈 위치 - 1) 반환
			if (pos < 0)
				pos = -(pos + 1); // 이분 탐색 위치 변환

			if (pos == lis.size()) {
				lis.add(x); // 새로 추가
			} else {
				lis.set(pos, x); // 값 교체
			}

		}
		return lis.size(); // LIS 길이 반환
	}
}
