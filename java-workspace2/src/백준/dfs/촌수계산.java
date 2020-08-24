package 백준.dfs;

import java.util.Scanner;

public class 촌수계산 {
	static Scanner scanner = new Scanner(System.in);
	static int countOfPeople;
	static boolean[][] connections;
	static boolean[] visited;
	static int answer = 0;

	public static void main(String[] args) {
		countOfPeople = scanner.nextInt();
		int source = scanner.nextInt();
		int dest = scanner.nextInt();
		int countOfConnection = scanner.nextInt();
		connections = new boolean[countOfPeople + 1][countOfPeople + 1];
		visited = new boolean[countOfPeople + 1];
		for (int i = 0; i < countOfConnection; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			connections[from][to] = true;
			connections[to][from] = true;
		}
		DFS(source, dest, 0);
		if (answer == 0) {
			answer = -1;
		}
		System.out.println(answer);
	}

	private static void DFS(int current, int target, int count) {
		if (current == target) {
			answer = count;
		}
		visited[current] = true;
		for (int i = 1; i <= countOfPeople; i++) {
			if (connections[current][i] && !visited[i]) {
				visited[i] = true;
				DFS(i, target, count + 1);
			}
		}
	}
}
