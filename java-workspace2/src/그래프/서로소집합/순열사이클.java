package 그래프.서로소집합;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 순열사이클 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int countOfNumber = scanner.nextInt();
			int[] numbers = new int[countOfNumber + 1];
			int[] parents = new int[countOfNumber + 1];
			for (int idx = 1; idx <= countOfNumber; idx++) {
				numbers[idx] = scanner.nextInt();
			}
			for (int idx = 1; idx <= countOfNumber; idx++) {
				if (parents[idx] == 0) {
					if (numbers[idx] == idx) {
						parents[idx] = idx;
					} else {
						union(numbers, parents, idx, idx);
					}
				}
			}
			Set<Integer> parentSet = new HashSet<>();
			for (int idx = 1; idx <= countOfNumber; idx++) {
				parentSet.add(parents[idx]);
			}
			System.out.println(parentSet.size());
		}
	}

	private static void union(int[] numbers, int[] parents, int parent, int target) {
		parents[target] = parent;
		if (parents[numbers[target]] == 0) {
			union(numbers, parents, parent, numbers[target]);
		}
	}
}
