package 분류안함;

import java.util.Scanner;

public class 집합의표현 {
	static Scanner scanner = new Scanner(System.in);
	static int countOfNumber;
	static int countOfOrder;

	public static void main(String[] args) {
		countOfNumber = scanner.nextInt();
		countOfOrder = scanner.nextInt();
		int[] parents = new int[countOfNumber + 1];
		for (int idx = 1; idx <= countOfNumber; idx++) {
			parents[idx] = idx;
		}
		for (int idx = 0; idx < countOfOrder; idx++) {
			int order = scanner.nextInt();
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			if (order == 0) {
				union(parents, a, b);
			} else {
				int parentA = find(parents, a);
				int parentB = find(parents, b);
				System.out.println(parentA == parentB ? "YES" : "NO");
			}
		}
	}

	private static void union(int[] parents, int a, int b) {
		int parentA = find(parents, a);
		int parentB = find(parents, b);

		if (parentA < parentB) {
			parents[parentB] = parentA;
		} else {
			parents[parentA] = parentB;
		}
	}

	private static int find(int[] parent, int target) {
		if (parent[target] != target) {
			parent[target] = find(parent, parent[target]);
		}
		return parent[target];
	}
}
