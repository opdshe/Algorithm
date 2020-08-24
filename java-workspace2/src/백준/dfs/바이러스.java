package 백준.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스 {
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int countOfComputer = scanner.nextInt();
		int countOfConnection = scanner.nextInt();
		boolean[][] connections = new boolean[countOfComputer + 1][countOfComputer + 1];
		visited = new boolean[countOfComputer + 1];

		for (int i = 0; i < countOfConnection; i++) {
			int source = scanner.nextInt();
			int dest = scanner.nextInt();
			connections[source][dest] = true;
			connections[dest][source] = true;
		}
		BFS(connections);

	}

	private static void BFS(boolean[][] connections) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;
		int answer = 0;

		while (!queue.isEmpty()) {
			answer++;
			Integer current = queue.poll();
			for (int i = 1; i < connections.length; i++) {
				if (connections[current][i] && !queue.contains(i) && !visited[i]) {
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		System.out.println(answer - 1);
	}
}
