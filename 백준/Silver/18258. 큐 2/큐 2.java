import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Deque<Integer> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if (command.equals("push")) {
				int X = Integer.parseInt(st.nextToken());
				queue.add(X);
			} else if (command.equals("pop")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.pollFirst()).append("\n");
				}
			} else if (command.equals("size")) {
				sb.append(queue.size()).append("\n");
			} else if (command.equals("empty")) {
				if (queue.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			} else if (command.equals("front")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.peekFirst()).append("\n");
				}
			} else if (command.equals("back")) {
				if (queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.peekLast()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}