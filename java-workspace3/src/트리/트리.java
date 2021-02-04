package 트리;

import java.util.*;

public class 트리 {
	static Scanner scanner = new Scanner(System.in);
	static Map<Integer, List<Integer>> tree = new HashMap<>();

	public static void main(String[] args) {
		int root = -1;
		int countOfNode = scanner.nextInt();
		init(countOfNode);
		for (int idx = 0; idx < countOfNode; idx++) {
			int parent = scanner.nextInt();
			if (parent == -1) {
				root = idx;
			} else {
				List<Integer> child = tree.get(parent);
				child.add(idx);
				tree.put(parent, child);
			}
		}
		int removeTarget = scanner.nextInt();
		int answer = getLeafNode(removeTarget, root);
		System.out.println(answer);
	}

	private static int getLeafNode(int removeTarget, int current) {
		if (current == removeTarget) {
			return 0;
		}
		if (tree.get(current).size() == 0) {
			return 1;
		}
		int sum = 0;
		for (Integer child : tree.get(current)) {
			if (child != removeTarget) {
				sum += getLeafNode(removeTarget, child);
			}
		}
		if (sum == 0) {
			sum = 1;
		}
		return sum;
	}

	private static void init(int countOfNode) {
		for (int idx = 0; idx < countOfNode; idx++) {
			tree.put(idx, new ArrayList<>());
		}
	}
}
