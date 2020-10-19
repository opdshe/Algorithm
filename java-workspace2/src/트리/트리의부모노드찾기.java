package 트리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 트리의부모노드찾기 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int countOfNode = scanner.nextInt();
		int[] parents = new int[countOfNode + 1];
		List<Integer>[] adjacent = new ArrayList[countOfNode + 1];
		for (int idx = 1; idx <= countOfNode; idx++) {
			adjacent[idx] = new ArrayList<>();
		}
		parents[1] = 1;

		for (int i = 0; i < countOfNode - 1; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			adjacent[source].add(dest);
			adjacent[dest].add(source);
		}
		boolean[] visited = new boolean[countOfNode + 1];
		connect(parents, adjacent, visited, 1);
		for (int idx = 2; idx <= countOfNode; idx++) {
			System.out.println(parents[idx]);
		}
	}

	private static void connect(int[] parents, List<Integer>[] adjacent, boolean[] visited, int node) {
		visited[node] = true;
		for (Integer integer : adjacent[node]) {
			if (!visited[integer]) {
				parents[integer] = node;
				connect(parents, adjacent, visited, integer);
			}
		}
	}
}
