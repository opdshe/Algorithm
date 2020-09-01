package 테스트;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 길찾기 {
	static int[] preorderArray;
	static int[] postorderArray;
	static int traversalIdx = 0;
	static List<Node> nodeList = new ArrayList<>();

	public static void main(String[] args) {
		solution(new int[][]{{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}});
	}

	public static int[][] solution(int[][] nodeinfo) {
		for (int i = 0; i < nodeinfo.length; i++) {
			nodeList.add(new Node(i + 1, nodeinfo[i][1], nodeinfo[i][0]));
		}
		nodeList.sort(new myComparator());
		Tree tree = new Tree();
		for (Node node : nodeList) {
			tree.addNode(node);
		}
		preorderArray = new int[nodeinfo.length];
		postorderArray = new int[nodeinfo.length];
		tree.preorderTraversal(tree.root);
		traversalIdx = 0;
		tree.postorderTraversal(tree.root);
		System.out.println(Arrays.toString(preorderArray));
		System.out.println(Arrays.toString(postorderArray));
		return null;
	}

	private static class myComparator implements Comparator<Node> {

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

	private static class Tree {
		Node root;

		private void addNode(Node node) {
			if (root == null) {
				root = node;
			} else {
				addNode(node, root);
			}
		}

		private void addNode(Node node, Node root) {
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

		private void preorderTraversal(Node node) {
			if (node == null) {
				return;
			}
			preorderArray[traversalIdx] = node.idx;
			traversalIdx++;
			preorderTraversal(node.left);
			preorderTraversal(node.right);
		}

		private void postorderTraversal(Node node) {
			if (node == null) {
				return;
			}
			postorderTraversal(node.left);
			postorderTraversal((node.right));
			postorderArray[traversalIdx] = node.idx;
			traversalIdx++;
		}
	}

	private static class Node {
		private int idx;
		private int y;
		private int x;
		private Node left;
		private Node right;

		public Node(int idx, int y, int x) {
			this.idx = idx;
			this.y = y;
			this.x = x;
		}
	}
}