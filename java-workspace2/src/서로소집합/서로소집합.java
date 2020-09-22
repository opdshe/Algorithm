package 서로소집합;

import java.util.Scanner;

public class 서로소집합 {
	static Scanner scanner = new Scanner(System.in);
	static int[] parents;

	public static void main(String[] args) {
		int N = scanner.nextInt();
		int countOfOrder = scanner.nextInt();
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < countOfOrder; i++) {
			int A = scanner.nextInt();
			int B = scanner.nextInt();
			union(A, B);
		}
		for (int i = 1; i <= N; i++) {
			System.out.println(parents[i]);
		}
	}

	private static void union(int a, int b) {
		int parentA = getParents(a);
		int parentB = getParents(b);
		if (parentA < parentB) {
			parents[parentB] = parentA;
		} else {
			parents[parentA] = parentB;
		}
	}

	private static int getParents(int child) {
		if (parents[child] != child) {
			parents[child] = getParents(parents[child]);
		}
		return parents[child];
	}
}
