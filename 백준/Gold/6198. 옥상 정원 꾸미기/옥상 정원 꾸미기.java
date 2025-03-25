import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static int N;
	static int[] building;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		building = new int[N];
		for (int i = 0; i < N; i++) {
			building[i] = Integer.parseInt(br.readLine());
		}
		// i번째 빌딩의 키 h_i
		// 오른쪽으로만 볼 수 있음
		// i보다 큰 위치에서 i보다 작은 개수
		// Stack에 자기보다 낮은 건물들을 유지
		long cnt = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && stack.peek() <= building[i]) {
				stack.pop();
			}
			cnt += stack.size();
			stack.add(building[i]);
		}
		System.out.println(cnt);

	}
}
