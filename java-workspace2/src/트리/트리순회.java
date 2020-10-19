package 트리;

import java.util.HashMap;
import java.util.Scanner;

public class 트리순회 {
	static HashMap<String, Node> tree = new HashMap<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNode = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < countOfNode; i++) {
			String[] nodeInfo = scanner.nextLine().split(" ");
			tree.put(nodeInfo[0], new Node(nodeInfo[0], nodeInfo[1], nodeInfo[2]));
		}
		printPreOrder(tree.get("A"));
		System.out.println();
		printInOrder(tree.get("A"));
		System.out.println();
		printPostOrder(tree.get("A"));

	}

	private static void printPreOrder(Node node) {
		System.out.print(node.idx);
		if (!node.left.equals(".")) {
			printPreOrder(tree.get(node.left));
		}
		if (!node.right.equals(".")) {
			printPreOrder(tree.get(node.right));
		}
	}

	private static void printInOrder(Node node) {
		if (!node.left.equals(".")) {
			printInOrder(tree.get(node.left));
		}
		System.out.print(node.idx);
		if (!node.right.equals(".")) {
			printInOrder(tree.get(node.right));
		}
	}

	private static void printPostOrder(Node node) {
		if (!node.left.equals(".")) {
			printPostOrder(tree.get(node.left));
		}
		if (!node.right.equals(".")) {
			printPostOrder(tree.get(node.right));
		}
		System.out.print(node.idx);

	}

	private static class Node {
		private String idx;
		private String left;
		private String right;

		public Node(String idx, String left, String right) {
			this.idx = idx;
			this.left = left;
			this.right = right;
		}
	}
}
