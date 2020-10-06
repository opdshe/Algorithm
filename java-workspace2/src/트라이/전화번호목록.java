package 트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 전화번호목록 {
	static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int testcase = Integer.parseInt(bufferedReader.readLine());
		for (int test = 0; test < testcase; test++) {
			int countOfNumbers = Integer.parseInt(bufferedReader.readLine());
			Trie trie = new Trie();
			List<String> numbers = new ArrayList<>();
			boolean isOkay = true;
			for (int idx = 0; idx < countOfNumbers; idx++) {
				String number = bufferedReader.readLine();
				numbers.add(number);
			}
			numbers.sort(Comparator.comparing(String::length));
			for (String number : numbers) {
				if (!trie.add(number)) {
					isOkay = false;
					break;
				}
			}
			System.out.println(isOkay ? "YES" : "NO");
		}
	}

	private static class Trie {
		Node root = new Node();

		private boolean add(String number) {
			Node current = root;
			for (int idx = 0; idx < number.length(); idx++) {
				if (current.isLastNumber) {
					return false;
				}
				char target = number.charAt(idx);
				if (!current.child.containsKey(target)) {
					current.child.put(target, new Node());
				}
				current = current.child.get(target);
			}
			current.isLastNumber = true;
			return true;
		}
	}

	private static class Node {
		private Map<Character, Node> child = new HashMap<>();

		private boolean isLastNumber;
	}
}
