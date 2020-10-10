package 기출.카카오.카카오상반기2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 가사검색 {
	public static void main(String[] args) {
		solution(new String[]{"frodo", "frontf", "frost", "frozen", "frame", "kakao"},
				new String[]{"fro??", "s??", "?????f"});
	}

	public static int[] solution(String[] words, String[] queries) {
		Trie trie = new Trie();
		int[] answer = new int[queries.length];
		for (String word : words) {
			trie.add(word);
		}
		for (int idx = 0; idx < queries.length; idx++) {
			answer[idx] = trie.getCountOfCandidate(queries[idx]);
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}

	private static class Trie {
		private Node front;
		private Node back;

		private Trie() {
			front = new Node();
			back = new Node();
		}

		public void add(String word) {
			Node currentFrontNode = front;
			Node currentBackNode = back;
			for (int i = 0; i < word.length(); i++) {
				currentFrontNode.countOfChild.put(word.length(), currentFrontNode.countOfChild.getOrDefault(word.length(), 0) + 1);
				currentFrontNode = currentFrontNode.child.computeIfAbsent(word.charAt(i), node -> new Node());

				currentBackNode.countOfChild.put(word.length(), currentBackNode.countOfChild.getOrDefault(word.length(), 0) + 1);
				currentBackNode = currentBackNode.child.computeIfAbsent(word.charAt(word.length() - i - 1), node -> new Node());
			}
		}

		private int getCountOfCandidate(String word) {
			if (word.charAt(0) == '?') {
				return getCountOfCandidateFromBack(word);
			}
			return getCountOfCandidateFromFront(word);
		}

		private int getCountOfCandidateFromFront(String word) {
			Node currentNode = front;
			for (int idx = 0; idx < word.length(); idx++) {
				if (word.charAt(idx) == '?') {
					break;
				}
				if (currentNode.child.containsKey(word.charAt(idx))) {
					currentNode = currentNode.child.get(word.charAt(idx));
				} else {
					return 0;
				}
			}
			return currentNode.countOfChild.getOrDefault(word.length(), 0);
		}

		private int getCountOfCandidateFromBack(String word) {
			Node currentNode = back;
			for (int idx = word.length() - 1; idx >= 0; idx--) {
				if (word.charAt(idx) == '?') {
					break;
				}
				if (currentNode.child.containsKey(word.charAt(idx))) {
					currentNode = currentNode.child.get(word.charAt(idx));
				} else {
					return 0;
				}
			}
			return currentNode.countOfChild.getOrDefault(word.length(), 0);
		}
	}

	private static class Node {
		private Map<Character, Node> child = new HashMap<>();
		private Map<Integer, Integer> countOfChild = new HashMap<>();
	}
}
