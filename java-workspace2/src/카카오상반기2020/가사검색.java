package 카카오상반기2020;

import java.util.HashMap;
import java.util.Map;

public class 가사검색 {
	public static void main(String[] args) {
		solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
				new String[]{"fro??", "????o", "fr???", "fro???", "pro?"});
	}

	public static int[] solution(String[] words, String[] queries) {
		Trie trie = new Trie('*');
		for (String word : words) {
			Trie node = trie;
			for (int i = 0; i < word.length(); i++) {
				char target = word.charAt(i);
				node.insert(target);
				node = node.child.get(target);
			}
		}
		return null;
	}

	private static class Trie {
		char character;
		Map<Character, Trie> child;

		public Trie(char character) {
			this.character = character;
			child = new HashMap<>();
		}

		private void insert(char character) {
			if (!child.containsKey(character)) {
				child.put(character, new Trie(character));
			}
		}

		private int getCountOfChild() {
			if (child.size() == 0) {
				return 1;
			}
			int count = 0;
			for (Trie value : child.values()) {
				count += value.getCountOfChild();
			}
			return count;
		}
	}
}
