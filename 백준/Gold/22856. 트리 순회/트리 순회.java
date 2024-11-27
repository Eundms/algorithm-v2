import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N; // 노드의 개수
	static Node[] tree;
	static List<Integer> path = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			tree[a] = new Node(a, b, c);
		}

		traverse(1);
		int rightNodeCnt = 0;
		for (int i = 1; tree[i].right != -1; i = tree[i].right) {
			rightNodeCnt += 1;
		}
		int moveCnt = (N - 1) * 2;
		moveCnt -= rightNodeCnt;

		System.out.println(moveCnt);
	}

	static void traverse(int value) {
		if (value == -1) {
			return;
		}
		traverse(tree[value].left);
		path.add(value);
		traverse(tree[value].right);

	}

	static class Node {
		int value;
		int left, right;

		Node(int value, int left, int right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

}
