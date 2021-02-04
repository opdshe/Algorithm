package 재귀;

import java.util.Scanner;

public class 이진검색트리 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		Tree tree = new Tree();
		while (scanner.hasNext()) {
			try {
				int value = scanner.nextInt();
				tree.add(value);
			} catch (Exception e) {
				break;
			}
		}
		tree.root.printPostOrder();
	}

	private static class Tree {
		Node root;

		private void add(int target) {
			if (root == null) {
				root = new Node(target);
			} else {
				root.add(target);
			}
		}
	}

	private static class Node {
		int value;
		Node left;
		Node right;

		private void add(int target) {
			if (target > value) {
				if (right == null) {
					right = new Node(target);
				} else {
					right.add(target);
				}
			} else {
				if (left == null) {
					left = new Node(target);
				} else {
					left.add(target);
				}
			}
		}

		private void printPostOrder() {
			if (left != null) {
				left.printPostOrder();
			}
			if (right != null) {
				right.printPostOrder();
			}
			System.out.println(value);
		}

		public Node(int value) {
			this.value = value;
		}
	}
}
