package 완전탐색;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 숫자고르기 {
	static Scanner scanner = new Scanner(System.in);
	static List<Integer> answer = new ArrayList<>();


	public static void main(String[] args) {
		int countOfNumber = scanner.nextInt();
		int[] numbers = new int[countOfNumber + 1];
		for (int idx = 1; idx <= countOfNumber; idx++) {
			numbers[idx] = scanner.nextInt();
		}
		boolean[] visited = new boolean[countOfNumber + 1];
		for (int idx = 1; idx <= countOfNumber; idx++) {
			if (!visited[idx]) {
				dfs(numbers, visited, idx, idx);
			}
		}
		answer.sort(Comparator.naturalOrder());
		System.out.println(answer.size());
		answer.forEach(System.out::println);
	}

	private static boolean dfs(int[] numbers, boolean[] visited, int start, int current) {
		if (numbers[current] == start) {
			answer.add(current);
			return true;
		}
		visited[current] = true;
		if (!visited[numbers[current]]) {
			if (dfs(numbers, visited, start, numbers[current])) {
				answer.add(current);
				return true;
			}
		}
		visited[current] = false;
		return false;
	}
}
