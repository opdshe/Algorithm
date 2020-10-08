package 재귀;

import java.util.Scanner;

public class 이진검색트리 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Tree tree = new Tree();
		while (scanner.hasNext()) {
			try {
				int value = scanner.nextInt();
				tree.add(new Node(value));
			} catch (Exception e) {
				break;
			}

		}
		tree.printPostOrder(tree.root);
	}

	private static class Tree {
		Node root;

		private void printPostOrder(Node node) {
			if (node == null) {
				return;
			}
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.println(node.value);
		}

		private void add(Node node) {
			if (root == null) {
				root = node;
			} else {
				add(node, root);
			}
		}

		private void add(Node node, Node root) {
			if (node.value < root.value) {
				if (root.left == null) {
					root.left = node;
				} else {
					add(node, root.left);
				}
			} else {
				if (root.right == null) {
					root.right = node;
				} else {
					add(node, root.right);
				}
			}
		}
	}

	private static class Node {
		private int value;
		private Node left;
		private Node right;

		public Node(int value) {
			this.value = value;
		}
	}
}
