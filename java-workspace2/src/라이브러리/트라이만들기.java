package 라이브러리;

import java.util.HashMap;
import java.util.Map;

public class 트라이만들기 {
	public static void main(String[] args) {
		String[] words = new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"};
		Trie trie = new Trie();
		for (String word : words) {
			trie.add(word);
		}

		String[] targets = new String[]{"fro??", "fr???", "fro???", "pro?"};
		for (String target : targets) {
			System.out.println(trie.getCountOfChild(target));
		}

	}

	private static class Trie {
		Node root;

		private Trie() {
			root = new Node();
		}

		private void add(String word) {
			Node current = root;
			for (int idx = 0; idx < word.length(); idx++) {
				current.count++;
				current.countOfChild.put(word.length(), current.countOfChild.getOrDefault(word.length(), 0) + 1);
				current = current.child.computeIfAbsent(word.charAt(idx), c -> new Node());
			}
			current.isLastCharacter = true;
		}

		private boolean contains(String word) {
			Node current = root;
			for (int idx = 0; idx < word.length(); idx++) {
				if (current.child.containsKey(word.charAt(idx))) {
					current = current.child.get(word.charAt(idx));
				} else {
					return false;
				}
			}
			return current.isLastCharacter;
		}

		private int getCountOfChild(String word) {
			Node current = root;
			for (int idx = 0; idx < word.length(); idx++) {
				if (word.charAt(idx) == '?') {
					break;
				}
				if (current.child.containsKey(word.charAt(idx))) {
					current = current.child.get(word.charAt(idx));
				} else {
					return 0;
				}
			}
			return current.countOfChild.get(word.length());
		}
	}

	private static class Node {
		private Map<Character, Node> child = new HashMap<>();
		private Map<Integer, Integer> countOfChild = new HashMap<>();
		private int count;
		private boolean isLastCharacter;
	}
}
