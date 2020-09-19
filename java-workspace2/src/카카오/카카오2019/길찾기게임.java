package 카카오.카카오2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 길찾기게임 {
	static int countOfNode;
	static List<Node> nodeList = new ArrayList<>();
	static int[] preOrder;
	static int[] postOrder;
	static int idx;

	public static void main(String[] args) {
		solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});
	}

	public static int[][] solution(int[][] nodeinfo) {
		countOfNode = nodeinfo.length;
		preOrder = new int[countOfNode];
		postOrder = new int[countOfNode];
		for (int i = 0; i < countOfNode; i++) {
			int[] position = nodeinfo[i];
			nodeList.add(new Node(i + 1, position[1], position[0]));
		}

		nodeList.sort(new UpperLeft());
		Tree tree = new Tree();

		for (Node node : nodeList) {
			tree.addNode(node);
		}
		idx = 0;
		preorder(tree.root);
		idx = 0;
		postorder(tree.root);
		return new int[][]{preOrder, postOrder};
	}

	private static void preorder(Node node) {
		if (node == null) {
			return;
		}
		preOrder[idx] = node.nodeNumber;
		idx++;
		preorder(node.left);
		preorder(node.right);
	}

	private static void postorder(Node node) {
		if (node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		postOrder[idx] = node.nodeNumber;
		idx++;
	}


	private static class Tree {
		private Node root;


		public void addNode(Node node) {
			if (root == null) {
				root = node;
			} else {
				addNode(node, root);
			}
		}

		public void addNode(Node node, Node root) {
			if (node.x < root.x) {
				if (root.left == null) {
					root.left = node;
				} else {
					addNode(node, root.left);
				}
			} else {
				if (root.right == null) {
					root.right = node;
				} else {
					addNode(node, root.right);
				}
			}
		}
	}

	private static class Node {
		private int nodeNumber;
		private int y;
		private int x;
		private Node left;
		private Node right;

		public Node(int nodeNumber, int y, int x) {
			this.nodeNumber = nodeNumber;
			this.y = y;
			this.x = x;
		}
	}

	private static class UpperLeft implements Comparator<Node> {

		@Override
		public int compare(Node o1, Node o2) {
			if (o1.y < o2.y) {
				return 1;
			} else if (o1.y == o2.y) {
				if (o1.x > o2.x) {
					return 1;
				}
			}
			return -1;
		}
	}
}