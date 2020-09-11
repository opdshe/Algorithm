package 카카오2018공채;

import java.util.HashMap;
import java.util.Map;

public class 자동완성 {
	public static void main(String[] args) {
		solution(new String[]{"go", "gone", "guild"});
	}

	public static int solution(String[] words) {
		Trie trie = new Trie();
		int sum = 0;
		for (String word : words) {
			trie.add(word);
		}
		for (String word : words) {
			sum += trie.getCountOfPush(word);
		}
		System.out.println(sum);
		return sum;
	}

	private static class Trie {
		Node root;

		private Trie() {
			root = new Node();
		}

		public void add(String word) {
			Node currentNode = root;
			for (int idx = 0; idx < word.length(); idx++) {
				currentNode.countOfChild++;
				currentNode = currentNode.child.computeIfAbsent(word.charAt(idx), node -> new Node());
			}
			currentNode.isLastCharacter = true;
		}

		private int getCountOfPush(String word) {
			Node currentNode = root;
			int count = 0;
			for (int idx = 0; idx < word.length(); idx++) {
				if (currentNode.countOfChild > 1) {
					currentNode = currentNode.child.get(word.charAt(idx));
					count++;
				} else {
					if (currentNode.isLastCharacter) {
						currentNode = currentNode.child.get(word.charAt(idx));
						count++;
					} else {
						break;
					}
				}
			}
			return count;
		}
	}

	private static class Node {
		private Map<Character, Node> child = new HashMap<>();
		private int countOfChild;
		private boolean isLastCharacter;
	}
}