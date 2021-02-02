package 문자열.트라이;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 전화번호목록 {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(bf.readLine());
		for (int test = 0; test < testcase; test++) {
			int countOfNumbers = Integer.parseInt(bf.readLine());
			Trie trie = new Trie();
			List<String> numbers = new ArrayList<>();
			for (int i = 0; i < countOfNumbers; i++) {
				numbers.add(bf.readLine());
			}
			numbers.sort(Comparator.comparing(String::length));
			boolean result = numbers.stream()
					.allMatch(trie::add);
			System.out.println(result ? "YES" : "NO");
		}
	}

	private static class Trie {
		Node root = new Node();

		private boolean add(String number) {
			Node node = root;
			for (int idx = 0; idx < number.length(); idx++) {
				if (node.isLastCharacter) {
					return false;
				}
				char current = number.charAt(idx);
				node = node.children.computeIfAbsent(current, c -> new Node());
			}
			node.isLastCharacter = true;
			return true;
		}
	}

	private static class Node {
		Map<Character, Node> children = new HashMap<>();
		boolean isLastCharacter;
	}
}
