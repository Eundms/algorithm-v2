import java.util.*;

class Solution {

	public boolean solution(String[] phone_book) {

		for (String phone : phone_book) {
			if (!insert(phone)) {
				return false;
			}
		}

		return true;
	}

	static class TrieNode {
		private boolean isEnd;
		private Map<Character, TrieNode> children = new HashMap<>();
	}

	static TrieNode root = new TrieNode();

	static boolean insert(String phone) {
		TrieNode current = root;
		for (char c : phone.toCharArray()) {
			current.children.putIfAbsent(c, new TrieNode());
			current = current.children.get(c);
			if (current.isEnd) { // 번호 중간에서 이미 끝인 경우
				return false;
			}
		}
		current.isEnd = true;
		return current.children.isEmpty();
	}
}
