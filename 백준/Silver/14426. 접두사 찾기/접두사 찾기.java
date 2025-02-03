import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 문자열의 개수
	static List<Integer> box;
	static Trie root = new Trie();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int n = 0; n < N; n++) {
			insert(br.readLine());
		}
		int cnt = 0;
		for (int m = 0; m < M; m++) {
			if (find(br.readLine())) {
				cnt += 1;
			}
		}
		System.out.println(cnt);

	}

	static boolean find(String str) {
		Trie cur = root;
		for (char next : str.toCharArray()) {
			if (cur.children.containsKey(next)) {
				cur = cur.children.get(next);
			} else {
				return false;
			}

		}
		return true;
	}

	static void insert(String str) {
		Trie cur = root;
		for (char next : str.toCharArray()) {
			cur.children.putIfAbsent(next, new Trie());
			cur = cur.children.get(next);
		}
		cur.isEndOfWord = true;
	}

	static class Trie {
		Map<Character, Trie> children;
		boolean isEndOfWord;

		Trie() {
			isEndOfWord = false;
			children = new HashMap<>();
		}
	}

}
