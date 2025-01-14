import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine()); // 전화번호의 수
			Trie trie = new Trie();

			List<String> phones = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				phones.add(br.readLine());
			}
			Collections.sort(phones, Comparator.comparing(x -> -x.length()));
			String ans = "YES";
			for (int i = 0; i < n; i++) {
				String str = phones.get(i);
				if (trie.startsWith(str)) {
					ans = "NO";
				}
				trie.insert(str);
			}
			System.out.println(ans);

		}

	}

	static class Trie {
		class TrieNode {
			Map<Character, TrieNode> children;
			boolean isEndOfWord;

			TrieNode() {
				children = new HashMap<>();
				isEndOfWord = false;
			}
		}

		TrieNode root;

		Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode node = root;
			for (char w : word.toCharArray()) {
				node.children.putIfAbsent(w, new TrieNode());
				node = node.children.get(w);
			}
			node.isEndOfWord = true;
		}

		public boolean search(String word) {
			TrieNode node = root;
			for (char w : word.toCharArray()) {
				if (!node.children.containsKey(w)) {
					return false;
				}
				node = node.children.get(w);
			}
			return node.isEndOfWord;
		}

		public boolean startsWith(String prefix) {
			TrieNode node = root;
			for (char c : prefix.toCharArray()) {
				if (!node.children.containsKey(c)) {
					return false;
				}
				node = node.children.get(c);
			}
			return true;
		}
	}

}