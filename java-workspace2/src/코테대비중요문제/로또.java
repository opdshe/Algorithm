package 코테대비중요문제;

import java.util.Arrays;
import java.util.Scanner;

public class 로또 {
	static Scanner scanner = new Scanner(System.in);
	static boolean[] visited;
	static int[] array;
	static int[] numbers;
	static int count;

	public static void main(String[] args) {
		while (true) {
			numbers = Arrays.stream(scanner.nextLine().split(" "))
					.mapToInt(Integer::parseInt)
					.toArray();
			if (numbers.length == 1) {
				break;
			}
			combine(6);
		}
	}

	private static void combine(int n) {
		visited = new boolean[numbers.length];
		array = new int[n];
		count = 0;
		dfs(1, 0);
		System.out.println();
	}

	private static void dfs(int start, int level) {
		if (level == array.length) {
			count++;
			for (int value : array) {
				System.out.print(numbers[value] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				array[level] = i;
				dfs(i + 1, level + 1);
				visited[i] = false;
			}
		}
	}
}
