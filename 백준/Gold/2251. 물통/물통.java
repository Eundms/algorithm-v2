import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int A, B, C;
	static List<Integer> ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken()); // 비어있음
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken()); // 가득차있음
		ans = new ArrayList<>();
		bfs(0, 0, C);
		Collections.sort(ans);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

	static void bfs(int a, int b, int c) {
		boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];

		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { a, b, c });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (visited[now[0]][now[1]][now[2]])
				continue;
			if (now[0] == 0) {
				ans.add(now[2]);
			}
			visited[now[0]][now[1]][now[2]] = true;
			// B -> A
			if (now[0] + now[1] <= A) {
				queue.add(new int[] { now[0] + now[1], 0, now[2] });
			} else {
				queue.add(new int[] { A, now[0] + now[1] - A, now[2] });
			}

			// C -> A
			if (now[0] + now[2] <= A) {
				queue.add(new int[] { now[0] + now[2], now[1], 0 });
			} else {
				queue.add(new int[] { A, now[1], now[0] + now[2] - A });
			}

			// A -> B
			if (now[0] + now[1] <= B) {
				queue.add(new int[] { 0, now[0] + now[1], now[2] });
			} else {
				queue.add(new int[] { now[0] + now[1] - B, B, now[2] });
			}

			// C -> B
			if (now[1] + now[2] <= B) {
				queue.add(new int[] { now[0], now[1] + now[2], 0 });
			} else {
				queue.add(new int[] { now[0], B, now[1] + now[2] - B });

			}

			// B -> C
			if (now[1] + now[2] <= C) {
				queue.add(new int[] { now[0], 0, now[1] + now[2] });
			} else {
				queue.add(new int[] { now[0], now[1] + now[2] - C, C });
			}

			// A -> C
			if (now[0] + now[2] <= C) {
				queue.add(new int[] { 0, now[1], now[0] + now[2] });
			} else {
				queue.add(new int[] { now[0] + now[2] - C, now[1], C });

			}

		}
	}

}
