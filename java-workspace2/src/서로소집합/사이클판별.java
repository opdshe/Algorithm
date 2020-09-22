package 서로소집합;

import java.util.Scanner;

public class 사이클판별 {
	static Scanner scanner = new Scanner(System.in);
	static int countOfNode;
	static int countOfEdge;
	static int[] parents;

	public static void main(String[] args) {
		countOfNode = scanner.nextInt();
		countOfEdge = scanner.nextInt();
		parents = new int[countOfNode + 1];
		for (int idx = 1; idx <= countOfNode; idx++) {
			parents[idx] = idx;
		}

		for (int i = 0; i < countOfEdge; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			if (union(source, dest)) {
				System.out.println("사이클 발생");
			}
		}
	}

	private static boolean union(int a, int b) {
		int parentOfA = getParents(a);
		int parentOfB = getParents(b);
		if (parentOfA == parentOfB) {
			return true;
		} else if (parentOfA < parentOfB) {
			parents[parentOfB] = parentOfA;
			return false;
		} else {
			parents[parentOfA] = parentOfB;
			return false;
		}
	}

	private static int getParents(int target) {
		if (parents[target] != target) {
			return getParents(parents[target]);
		}
		return parents[target];
	}
}
