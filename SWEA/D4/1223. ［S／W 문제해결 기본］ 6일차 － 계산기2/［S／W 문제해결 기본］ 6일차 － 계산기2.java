import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	static int T; // tc 개수

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = 10;
		for (int test = 1; test <= T; test++) {
			int len = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			String line = br.readLine();
			Stack<Integer> num = new Stack<>();
			for (int i = 0; i < line.length(); i++) {
				char item = line.charAt(i);
				if (item >= '0' && item <= '9') {
					sb.append(item);
				} else {
					while (!stack.isEmpty() && (stack.peek() == '*' && item != '*')) {
						sb.append(stack.pop());
					}
					stack.add(item);

				}
			}
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			Stack<Integer> e = new Stack<>();
			for (int i = 0; i < sb.length(); i++) {
				if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
					e.add(sb.charAt(i) - '0');
				} else {
					int x = e.pop();
					int y = e.pop();
					if (sb.charAt(i) == '*') {
						e.add(x * y);
					} else if (sb.charAt(i) == '+') {
						e.add(x + y);
					}
				}
			}
			System.out.println("#" + test + " " + e.pop());

		}
	}

}