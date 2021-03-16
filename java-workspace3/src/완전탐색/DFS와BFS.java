package 완전탐색;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS {
	static Scanner scanner = new Scanner(System.in);
	static boolean[][] adjacent;

	public static void main(String[] args) {
		int countOfVertex = scanner.nextInt();
		int countOfEdge = scanner.nextInt();
		int start = scanner.nextInt();

		adjacent = new boolean[countOfVertex + 1][countOfVertex + 1];
		for (int i = 0; i < countOfEdge; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			adjacent[source][dest] = true;
			adjacent[dest][source] = true;
		}
		boolean[] visited = new boolean[countOfVertex + 1];
		DFS(visited, countOfVertex, start);
		System.out.println();
		BFS(countOfVertex, start);
	}

	private static void DFS(boolean[] visited, int countOfVertex, int vertex) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		for (int idx = 1; idx <= countOfVertex; idx++) {
			if (!visited[idx] && adjacent[vertex][idx]) {
				DFS(visited, countOfVertex, idx);
			}
		}
	}

	private static void BFS(int countOfVertex, int vertex) {
		boolean[] visited = new boolean[countOfVertex + 1];
		visited[vertex] = true;
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(vertex);

		while (!queue.isEmpty()) {
			Integer current = queue.poll();
			System.out.print(current + " ");
			for (int idx = 1; idx <= countOfVertex; idx++) {
				if (!visited[idx] && adjacent[current][idx]) {
					visited[idx] = true;
					queue.add(idx);
				}
			}
		}
	}
}
