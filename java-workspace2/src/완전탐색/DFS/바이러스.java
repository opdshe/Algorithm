package 완전탐색.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 바이러스 {
	static Scanner scanner = new Scanner(System.in);
	static List<Integer>[] adjacent;

	public static void main(String[] args) {
		int countOfComputer = scanner.nextInt();
		int countOfConnections = scanner.nextInt();
		adjacent = new ArrayList[countOfComputer + 1];
		for (int idx = 1; idx <= countOfComputer; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		for (int idx = 1; idx <= countOfConnections; idx++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			adjacent[source].add(dest);
			adjacent[dest].add(source);
		}

		boolean[] visited = new boolean[countOfComputer + 1];
		int answer = dfs(visited, 1) - 1;
		System.out.println(answer);
	}

	private static int dfs(boolean[] visited, int current) {
		visited[current] = true;
		int sum = 1;
		for (Integer integer : adjacent[current]) {
			if (!visited[integer]) {
				sum += dfs(visited, integer);
			}
		}
		return sum;
	}
}
