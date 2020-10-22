package 완전탐색.DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 이분그래프 {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int testcase = scanner.nextInt();
		for (int test = 0; test < testcase; test++) {
			int countOfNode = scanner.nextInt();
			int countOfEdge = scanner.nextInt();
			List<Integer>[] adjacent = new ArrayList[countOfNode + 1];
			for (int idx = 1; idx <= countOfNode; idx++) {
				adjacent[idx] = new ArrayList<>();
			}
			for (int idx = 0; idx < countOfEdge; idx++) {
				int source = scanner.nextInt();
				int dest = scanner.nextInt();
				adjacent[source].add(dest);
				adjacent[dest].add(source);
			}
			int[] visited = new int[countOfNode + 1];
			boolean result = true;
			for (int idx = 1; idx <= countOfNode; idx++) {
				if (visited[idx] == 0) {
					result = dfs(adjacent, visited, idx, 1);
				}
				if (!result) {
					break;
				}
			}
			System.out.println(result ? "YES" : "NO");
		}
	}

	private static boolean dfs(List<Integer>[] adjacent, int[] visited, int current, int flag) {
		visited[current] = flag;
		boolean result = true;
		for (Integer adj : adjacent[current]) {
			if (visited[adj] == 0) {
				result = dfs(adjacent, visited, adj, -flag);
			} else {
				if (visited[adj] == flag) {
					return false;
				}
			}
		}
		return result;
	}
}
