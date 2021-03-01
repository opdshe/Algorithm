package 트리;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 길찾기게임 {
	static List<Node> nodes = new ArrayList<>();

	public static int[][] solution(int[][] nodeinfo) {
		init(nodeinfo);
		Tree tree = new Tree();
		for (Node node : nodes) {
			tree.add(node);
		}
		int[][] answer = new int[2][2];
		answer[0] = tree.getPreorder();
		answer[1] = tree.getPostOrder();
		return answer;
	}

	private static void init(int[][] nodeinfo) {
		for (int idx = 0; idx < nodeinfo.length; idx++) {
			nodes.add(new Node(idx + 1, nodeinfo[idx][0], nodeinfo[idx][1]));
		}
		nodes.sort(Comparator.comparing(Node::getY).reversed());
	}

	private static class Tree {
		Node root;

		private void add(Node node) {
			if (root == null) {
				root = node;
			} else {
				add(node, root);
			}
		}

		private void add(Node node, Node root) {
			if (root.x > node.x) {
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

		private int[] getPreorder() {
			List<Integer> list = new ArrayList<>();
			root.preOrder(list);
			return list.stream()
					.mapToInt(Integer::valueOf)
					.toArray();
		}

		private int[] getPostOrder() {
			List<Integer> list = new ArrayList<>();
			root.postOrder(list);
			return list.stream()
					.mapToInt(Integer::valueOf)
					.toArray();
		}
	}


	private static class Node {
		private int idx;
		private int x;
		private int y;
		private Node left;
		private Node right;

		public Node(int idx, int x, int y) {
			this.idx = idx;
			this.x = x;
			this.y = y;
		}

		private void preOrder(List<Integer> list) {
			list.add(idx);
			if (left != null) {
				left.preOrder(list);
			}
			if (right != null) {
				right.preOrder(list);
			}
		}

		private void postOrder(List<Integer> list) {
			if (left != null) {
				left.postOrder(list);
			}
			if (right != null) {
				right.postOrder(list);
			}
			list.add(idx);
		}

		private int getY() {
			return y;
		}
	}
}
