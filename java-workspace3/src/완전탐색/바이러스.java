package 완전탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 바이러스 {
	static Scanner scanner = new Scanner(System.in);
	static List<Integer>[] adjacent;

	public static void main(String[] args) {
		int countOfComputers = scanner.nextInt();
		int countOfConnections = scanner.nextInt();
		boolean[] visited = new boolean[countOfComputers + 1];
		init(countOfComputers);
		for (int i = 0; i < countOfConnections; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			adjacent[source].add(dest);
			adjacent[dest].add(source);
		}
		int answer = dfs(visited, 1) - 1;
		System.out.println(answer);
	}

	private static int dfs(boolean[] visited, int current) {
		visited[current] = true;
		int sum = 1;
		for (Integer adj : adjacent[current]) {
			if (!visited[adj]) {
				sum += dfs(visited, adj);
			}
		}
		return sum;
	}


	private static void init(int countOfComputers) {
		adjacent = new ArrayList[countOfComputers + 1];
		for (int idx = 0; idx <= countOfComputers; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
	}
}
