package 트리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 트리의지름 {
	static Scanner scanner = new Scanner(System.in);
	static int maxCost = 0;
	static int nodeIdx = 0;

	public static void main(String[] args) {
		int countOfNode = scanner.nextInt();
		if (countOfNode == 1) {
			System.out.println(0);
			return;
		}
		List<Edge>[] edges = new ArrayList[countOfNode + 1];
		for (int idx = 1; idx <= countOfNode; idx++) {
			edges[idx] = new ArrayList<>();
		}
		for (int idx = 1; idx <= countOfNode - 1; idx++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			int cost = scanner.nextInt();
			edges[source].add(new Edge(dest, cost));
			edges[dest].add(new Edge(source, cost));
		}

		boolean[] visited = new boolean[countOfNode + 1];
		dfs(edges, visited, 1, 0);
		int a = nodeIdx;
		maxCost = 0;
		visited = new boolean[countOfNode + 1];
		dfs(edges, visited, a, 0);
		System.out.println(maxCost);
	}

	private static void dfs(List<Edge>[] edges, boolean[] visited, int current, int cost) {
		if (cost > maxCost) {
			maxCost = cost;
			nodeIdx = current;
		}
		visited[current] = true;
		for (Edge edge : edges[current]) {
			if (!visited[edge.dest]) {
				dfs(edges, visited, edge.dest, cost + edge.cost);
			}
		}
	}

	private static class Edge {
		private int dest;
		private int cost;

		public Edge(int dest, int cost) {
			this.dest = dest;
			this.cost = cost;
		}
	}
}
