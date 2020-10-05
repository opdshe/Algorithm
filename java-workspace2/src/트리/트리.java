package 트리;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 트리 {
	static List<Node> nodes = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNode = scanner.nextInt();
		for (int idx = 0; idx < countOfNode; idx++) {
			int parent = scanner.nextInt();
			Node node = new Node(idx, parent);
			nodes.add(node);
		}
		int target = scanner.nextInt();
		nodes.sort(Comparator.comparing(node -> node.parent));

		Tree tree = new Tree();
		tree.connectChild(nodes.get(0));
		tree.delete(tree.root, target);
		System.out.println(tree.getLeafNode(tree.root));

	}

	private static class Tree {
		private Node root;

		private int getLeafNode(Node node) {
			if (node.isDeleted) {
				return 0;
			}
			if (node.child.size() == 0) {
				//System.out.println("count" + node.idx);
				return 1;
			}
			int sum = 0;
			for (Node child : node.child) {
				sum += getLeafNode(child);
			}
			if (sum == 0) {
				//System.out.println("count" + node.idx);
				sum = 1;
			}
			return sum;
		}

		private void connectChild(Node current) {
			if (root == null) {
				root = current;
			}
			for (Node node : nodes) {
				if (node.parent == current.idx) {
					current.child.add(node);
					connectChild(node);
				}
			}
		}

		private void delete(Node node, int target) {
			if (node.idx == target) {
				node.isDeleted = true;
			} else {
				for (Node child : node.child) {
					delete(child, target);
				}
			}
		}
	}

	private static class Node {
		private int idx;

		private int parent;

		private boolean isDeleted;

		private int order;

		private List<Node> child = new ArrayList<>();

		public Node(int idx, int parent) {
			this.idx = idx;
			this.parent = parent;
		}
	}
}
