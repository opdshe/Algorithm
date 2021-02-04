package 재귀;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 트리순회 {
	static Scanner scanner = new Scanner(System.in);
	static Map<String, Node> tree = new HashMap<>();

	public static void main(String[] args) {
		int countOfNode = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < countOfNode; i++) {
			String[] info = scanner.nextLine().split(" ");
			tree.put(info[0], new Node(info));
		}
		printPreorder("A");
		System.out.println();
		printInorder("A");
		System.out.println();
		printPostOrder("A");

	}

	private static void printPreorder(String current) {
		if (current.equals(".")) {
			return;
		}
		System.out.print(current);
		printPreorder(tree.get(current).left);
		printPreorder(tree.get(current).right);
	}

	private static void printInorder(String current) {
		if (current.equals(".")) {
			return;
		}
		printInorder(tree.get(current).left);
		System.out.print(current);
		printInorder(tree.get(current).right);
	}

	private static void printPostOrder(String current) {
		if (current.equals(".")) {
			return;
		}
		printPostOrder(tree.get(current).left);
		printPostOrder(tree.get(current).right);
		System.out.print(current);
	}

	private static class Node {
		String name;
		String left;
		String right;

		public Node(String[] info) {
			this.name = info[0];
			this.left = info[1];
			this.right = info[2];
		}
	}
}
